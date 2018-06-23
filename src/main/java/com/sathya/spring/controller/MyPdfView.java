package com.sathya.spring.controller;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import com.sathya.spring.dao.Employee;

public class MyPdfView extends AbstractPdfView
{
	@Override
	protected void buildPdfDocument(Map m, Document doc,
			PdfWriter writer, HttpServletRequest request, HttpServletResponse response)
			throws Exception 
	{
		
		List   list=(List)m.get("employees");
		Iterator  it = list.iterator();
		
		Paragraph  p =new  Paragraph("Employees  list");
		p.setAlignment("center");
		
		Table  t =new  Table(4);//4  columns
		t.setAlignment("center");
		
		t.addCell("empno");  t.addCell("ename"); 
		t.addCell("sal");  t.addCell("deptno");
		
		while(it.hasNext())
		{
			Employee  e=(Employee)it.next();
			t.addCell(e.getEmpno()+"");
			t.addCell(e.getEname());
			t.addCell(e.getSal()+"");
			t.addCell(e.getDeptno()+"");
		}
		doc.add(p);
		doc.add(t);
	}
}
