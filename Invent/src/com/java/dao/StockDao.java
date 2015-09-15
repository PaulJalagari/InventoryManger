package com.java.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.java.db.DbConnection;
import com.java.to.StockInf;

public class StockDao {
	Connection connection;
	Statement stmt;
	public StockDao(){ }
	private static Connection getConnection() 
			throws SQLException,
			ClassNotFoundException
	{
		Connection con=DbConnection.
				getInstance().getConnection();
		return con;
	}
public List<StockInf> viewAllStock()
{
	String query="Select * from STOCKINFORM";
	List<StockInf> list=new ArrayList<StockInf>();
	StockInf stk=null;
	try{
		connection=getConnection();
		stmt=connection.createStatement();
		ResultSet rs=stmt.executeQuery(query);
		while(rs.next()){
			stk = new StockInf();
			stk.setCode(rs.getInt("Code"));
			stk.setItem(rs.getString("Item"));
			stk.setQuantity(rs.getInt("Quantity"));
			list.add(stk);
		}
		rs.close();
	}catch(Exception e){
		e.printStackTrace();
	}
	return list;
	}

}
