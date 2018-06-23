package com.sathya.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sathya.spring.dao.EmpDaoClass;

@Controller
public class TestController 
{
	@Autowired
	private   EmpDaoClass     dao;
	
	@RequestMapping("pdf")
	public  ModelAndView    viewPdf()
	{
		List  list=dao.getEmployeesList();
		return   new  ModelAndView("p", "employees", list);
	}
	
	@RequestMapping("excel")
	public   ModelAndView    viewExcel()
	{
		List  list = dao.getEmployeesList();
		return   new   ModelAndView("e", "employees",  list);
	}

}
