package com.tecsun.server;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecsun.dao.CsspQueryDAO;

/**
 * @author lwx
 * @date 2017年6月9日 上午10:58:57 
 */
@Service
public class DataExportService {
	
	@Autowired
	CsspQueryDAO csspQueryDAO;

	/**
	 * 把导出Excel任务交给线程池
	 * @return
	 */
	public boolean exportData2Excel(){
		//1、从数据库中查出数据总数
		int totalRow = csspQueryDAO.getPersonInfoCount();
		if(totalRow < 1){
			return false;
		}
		//2、将数据交给线程
		ForkJoinPool pool = new ForkJoinPool();
		pool.submit(new DataExportTask(1, totalRow));
		pool.shutdown();
		return true;
	}

	/**
	 * 开始导出数据到Excel
	 * 
	 * @param startRow	开始行
	 * @param endRow	结束行
	 * @return
	 */
	public boolean doExportData2Excel(int startRow, int endRow) {
		//查出startRow与endRow之间的数据
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		List<PersonInfo> list = csspQueryDAO.listPersonInfo(map);
		//poi导出数据
		if(list != null && list.size() > 0){
			createExcel(list);
		}
		return true;
	}
	
	private void createExcel(List<PersonInfo> list){
		SXSSFWorkbook wb = new SXSSFWorkbook();
		Sheet sheet = wb.createSheet();
		
		//第一行，表头
		Row row0 = sheet.createRow(0);
		String[] headers = {"ID","姓名","身份证号"};
		makeSheetHeaders(row0,headers);
		
		//第二行起，填充表数据
		for(int i = 0;i<list.size();i++){
			Row row = sheet.createRow(i + 1);
			PersonInfo personInfo = list.get(i);
			makeSheetRowData(row,personInfo);
		}
		
//		sheet.autoSizeColumn(1);
//		sheet.autoSizeColumn(2);
		
		//输出excle
		try {
			File file = new File("/temp/poi");
			if(!file.exists()){
				file.mkdirs();
			}
			FileOutputStream fileOut = new FileOutputStream(file+"/workbook_"+new Random().nextInt(10000)+".xlsx");
			wb.write(fileOut);
			fileOut.close();
			wb.dispose();
			wb.close();
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>excel export sucess");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 创建表头
	 */
	private void makeSheetHeaders(Row row0,String[] headers) {
		for(int i = 0;i<headers.length;i++){
			Cell cell = row0.createCell(i);
			cell.setCellValue(headers[i]);
		}
	}
	
	/**
	 * 创建Excel表中的一行数据
	 */
	private void makeSheetRowData(Row row, PersonInfo personInfo) {
		Cell c0 = row.createCell(0);
		c0.setCellValue(personInfo.getId());
		
		Cell c1 = row.createCell(1);
		c1.setCellValue(personInfo.getName());
		
		Cell c2 = row.createCell(2);
		c2.setCellValue(personInfo.getCertNum());
	}
	
	/**
	 * 线程任务类
	 */
	class DataExportTask extends RecursiveAction{
		private static final long serialVersionUID = -4594352250833831170L;
		//每个Excel的最大行数不大于THRESHOLD
		private static final int THRESHOLD = 400;
		private int startRow;
		private int endRow;
		
		public DataExportTask(int startRow,int endRow){
			this.startRow = startRow;
			this.endRow = endRow;
		}
		
		@Override
		protected void compute() {
			if (endRow - startRow <= THRESHOLD) {
				doExportData2Excel(startRow,endRow);
			} else {
				//如果结束行与开始行之差大于THRESHOLD，即要导出的行数大于THRESHOLD
				//把大任务分解成两个“小任务”
				int middle = (startRow + endRow)/2;
				DataExportTask leftTask = new DataExportTask(startRow, middle);
				DataExportTask rightTask = new DataExportTask(middle+1, endRow);
				//并行执行两个“小任务”
				leftTask.fork();
				rightTask.fork();
			}
		}
	}
}
