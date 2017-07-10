package com.tecsun.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tecsun.server.DataExportService;

/**
 * @author lwx
 * @date 2017年6月9日 下午2:57:01 
 */
@Controller
@RequestMapping(value = "/iface/cssp/export")
public class DataExportController {
	
	@Autowired
	DataExportService service;

	@RequestMapping(value = "/exportData2Excel", method = RequestMethod.GET)
    public void exportData2Excel(HttpServletRequest request) {
		service.exportData2Excel();
	}
}
