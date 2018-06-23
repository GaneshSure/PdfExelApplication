package com.sathya.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmployeeMapper implements RowMapper
{
	public Object mapRow(ResultSet rs, int index) throws SQLException 
	{
		Employee   e = new  Employee();
		e.setEmpno(rs.getInt(1));
		e.setEname(rs.getString(2));
		e.setSal(rs.getInt(3));
		e.setDeptno(rs.getInt(4));
		return  e;
	}
}
