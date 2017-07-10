package com.tecsun.server;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecsun.dao.CsspQueryDAO;

/**
 * @author lwx
 * @date 2017年6月14日 上午11:25:02 
 */
@Service
public class DataImportService {

	@Autowired
	CsspQueryDAO dao;
	
	/**
	 * 将导入数据的任务交给线程池
	 * 
	 * @return
	 */
	public boolean importDataFromExcel(){
		try {
			//存放excel的目录（存放的可以是excel文件或文件夹）
			File file = new File("/temp/poi");
			if(!file.exists() || !file.isDirectory() || file.list().length == 0  ){
				return false;
			}
			//将目录信息传给线程
			ForkJoinPool pool = new ForkJoinPool();
			pool.submit(new DataImportTask(file));
			pool.shutdown();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	/**
	 * 将excel表数据导入到数据库表
	 * 
	 * @param file	excel文件（.xls 或 .xlsx）
	 */
	private void doImportDataFromExcel(File file) {
		try {
			//1、 poi读取excel
			Workbook wb = WorkbookFactory.create(file);
			Sheet sheet = wb.getSheetAt(0);
			Iterator<Row> rowIt = sheet.rowIterator();
			List<PersonInfo> list = new ArrayList<PersonInfo>();
			while (rowIt.hasNext()) {
				Row row = rowIt.next();
				//跳过第一行，因为它是表头，如：ID,姓名,身份证号
				if(0 == row.getRowNum()){
					continue;
				}
				PersonInfo person = new PersonInfo();
				person.setId(row.getCell(0).getNumericCellValue());
				person.setName(row.getCell(1).getStringCellValue());
				person.setCertNum(row.getCell(2).getStringCellValue());
				list.add(person);
			}
			wb.close();
			
			//2、 把excel数据导入数据库
			dao.insertPersonInfo(list);
			System.out.println(">>>>>>>>>>>>>>>>>>excel import sucess ");
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 线程任务类
	 */
	class DataImportTask extends RecursiveAction {
		private static final long serialVersionUID = -7087385698050901628L;
		// excel所在目录或excel文件本身
		private File file;

		public DataImportTask(File file) {
			this.file = file;
		}

		@Override
		protected void compute() {
			if (file.isFile()) {// excel文件本身，则读取并导入数据
				doImportDataFromExcel(file);
			} else {// excel所在目录，则遍历目录并为每个excel开启一个线程
				File[] files = file.listFiles();
				for (int i = 0; i < files.length; i++) {
					File excelOrDir = files[i];
					DataImportTask task = new DataImportTask(excelOrDir/**excel或目录*/);
					task.fork();
				}
			}
		}
	}
}
