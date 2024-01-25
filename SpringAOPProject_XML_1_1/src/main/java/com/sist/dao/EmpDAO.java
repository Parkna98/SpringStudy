package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpDAO {
	private MyDataSource ds;
	private Connection conn;
	private PreparedStatement ps;
	
	public EmpDAO(MyDataSource ds) {
		this.ds=ds;
		try {
			Class.forName(ds.getDriver());
		}catch(Exception ex) {}
	}	
	
	public void getConnection() {
		try {
			conn=DriverManager.getConnection(ds.getUrl(),ds.getUsername(),ds.getPassword());
		}catch(Exception ex) {}
	}
	
	public void disConnection() {
		try {
			if(ps!=null)
				ps.close();
			if(conn!=null)
				conn.close();
		}catch(Exception ex) {}
	}
	
	public List<EmpVO> empListData(){
		List<EmpVO> list=new ArrayList<EmpVO>();
		// before => getConnection
		try {
			// Around
			String sql="SELECT empno,ename,job,TO_CHAR(hiredate,'YYYY-MM-DD'),sal "
					+ "FROM emp";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				EmpVO vo=new EmpVO();
				vo.setEmpno(rs.getInt(1));
				vo.setEname(rs.getString(2));
				vo.setJob(rs.getString(3));
				vo.setDbday(rs.getString(4));
				vo.setSal(rs.getInt(5));
				list.add(vo);
			}
			rs.close();
			// Around
		}catch(Exception ex) {
			// After-Throwing
			ex.printStackTrace();
		}finally {
			// after => disConnection
		}
		return list; // => After-Returning
	}
}
