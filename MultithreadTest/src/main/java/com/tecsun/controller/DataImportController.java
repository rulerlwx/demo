package com.tecsun.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tecsun.server.DataImportService;

/**
 * @author lwx
 * @date 2017年6月14日 上午11:17:51 
 */
@Controller
@RequestMapping(value = "/iface/cssp/import")
public class DataImportController {

	@Autowired
	DataImportService service;

	@RequestMapping(value = "/importDataFromExcel", method = RequestMethod.GET)
    public void importDataFromExcel(HttpServletRequest request) {
		service.importDataFromExcel();
	}
	
}
