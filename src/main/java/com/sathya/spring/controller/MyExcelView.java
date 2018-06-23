package com.sathya.spring.controller;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.sathya.spring.dao.Employee;


public class MyExcelView extends AbstractXlsView 
{
	
	protected void buildExcelDocument(Map m, Workbook wb,
			HttpServletRequest req, HttpServletResponse res) throws Exception 
	{
		Sheet    sheet =wb.createSheet("Sheet1");
		
		List   list =(List)m.get("employees");
		Iterator  it = list.iterator();
		
		Row   r1= sheet.createRow(0);
		
		Cell  c1= r1.createCell(0);
		c1.setCellValue("empno");
		
		Cell  c2=r1.createCell(1);
		c2.setCellValue("ename");
		
		Cell  c3=r1.createCell(2);
		c3.setCellValue("sal");
		
		Cell  c4=r1.createCell(3);
		c4.setCellValue("deptno");
		
		int  rowIndex=1;
		while(it.hasNext())
		{
			Employee  e=(Employee)it.next();
			
			Row   r = sheet.createRow(rowIndex);
			
			Cell  c5 = r.createCell(0);
			c5.setCellValue(e.getEmpno());
			
			Cell  c6 = r.createCell(1);
			c6.setCellValue(e.getEname());
			
			Cell  c7 = r.createCell(2);
			c7.setCellValue(e.getSal());
			
			Cell  c8 = r.createCell(3);
			c8.setCellValue(e.getDeptno());
			rowIndex++;
		}
	
	}
}
