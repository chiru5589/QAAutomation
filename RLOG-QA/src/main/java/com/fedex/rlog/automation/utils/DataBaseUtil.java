package com.fedex.rlog.automation.utils;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DataBaseUtil {
	
	private static String user = Config.getProperty("dbUser_name");
	private static String pwd = Config.getProperty("dbPwd");
	private static String url = Config.getProperty("dbUrl");
	
	

	 public DataBaseUtil(){
		
	 }
	
	public static void main(String[] args){
		
		Connection conn= null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try{
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			conn = DriverManager.getConnection(url,  user, pwd);
		    stmt = conn.createStatement();
		    rs = stmt.executeQuery("select * from RMAS where rma_number = '1234' and rma_ret_id = '42595'");
		    
		    while(rs.next()){
		    	//System.out.println(rs.getInt(1));
		    	System.out.println(rs.getString("RMA_created_time"));
		    }
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			if(conn !=null){
				try{
					conn.close();
				}catch(Exception e){}
			}
		}		
	}	
	
	public static boolean isRecordExisting (String query){
		
		Connection conn= null;
		Statement stmt = null;
		ResultSet rs = null;
		boolean isExisting = false;
		
		try{
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			conn = DriverManager.getConnection(url,  user, pwd);
		    stmt = conn.createStatement();
		    rs = stmt.executeQuery(query);
		    
		    while(rs.next()){
		    	isExisting = true;
		    }
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			if(conn !=null){
				try{
					conn.close();
				}catch(Exception e){}
			}
		}
		return isExisting;
	}
	
	public static String getFirstRowDataWithColumnName(String query, String columnName){
		
		Connection conn= null;
		Statement stmt = null;
		ResultSet rs = null;
		String columnData = null;
		
		try{
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			conn = DriverManager.getConnection(url,  user, pwd);
		    stmt = conn.createStatement();
		    rs = stmt.executeQuery(query);
		    
		    while(rs.next()){
		    	columnData = rs.getString(columnName);
		    	
		    }
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			if(conn !=null){
				try{
					conn.close();
				}catch(Exception e){}
			}
		}
		return columnData;
	}
	public static Map<String, String> getFirstRowDataWithColumnNames(String query, String... columnNames){
		//var-args
		Map<String, String> rowData = new HashMap<String, String>();

		Connection conn= null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try{
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			conn = DriverManager.getConnection(url,  user, pwd);
		    stmt = conn.createStatement();
		    rs = stmt.executeQuery(query);
		    
		    while(rs.next()){
		    	for(String columnLabel: columnNames){
		    		rowData.put(columnLabel, rs.getString(columnLabel));
		    	}
		    	break;
		    }
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			if(conn !=null){
				try{
					conn.close();
				}catch(Exception e){}
			}
		}
		return rowData;
	}
	
	public static List<String> getCellsFlattenedByRowsByColumnOrder(String query, String... columnNames){
		//var-args
		List<String> result = new ArrayList<String>();
		
		Connection conn= null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try{
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			conn = DriverManager.getConnection(url,  user, pwd);
		    stmt = conn.createStatement();
		    rs = stmt.executeQuery(query);
		    
		    while(rs.next()){
		    	for(String columnLabel: columnNames){
		    		result.add(rs.getString(columnLabel));
		    	}		    	
		    }
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			if(conn !=null){
				try{
					conn.close();
				}catch(Exception e){}
			}
		}
		return result;
	}
	
	

public static List<String> getColumnData(String query, String columnName){
		
		Connection conn= null;
		Statement stmt = null;
		ResultSet rs = null;
		List<String> columnData = new ArrayList<>();
		
		
		try{
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			conn = DriverManager.getConnection(url,  user, pwd);
		    stmt = conn.createStatement();
		    rs = stmt.executeQuery(query);
		    
		    while(rs.next()){
		    	columnData.add(rs.getString(columnName));
		    	
		    }
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			if(conn !=null){
				try{
					conn.close();
				}catch(Exception e){}
			}
		}
		return columnData;
	}


public static void UpdateData(String query){
		
		Connection conn= null;
		Statement stmt = null;
		ResultSet rs = null;
		String columnData = null;
		HashMap<Integer,String> data=new HashMap<Integer,String>();
		try{
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			conn = DriverManager.getConnection(url,  user, pwd);
		    stmt = conn.createStatement();
		    rs = stmt.executeQuery(query);
		    
		   
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			if(conn !=null){
				try{
					conn.close();
				}catch(Exception e){}
			}
		}
		
	}


public static HashMap<String,String> getRowsDataWithColumnName(String query, String columnName1,String columnName2){
		
		Connection conn= null;
		Statement stmt = null;
		ResultSet rs = null;
		String columnData = null;
		HashMap<String,String> data=new HashMap<String,String>();
		try{
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			conn = DriverManager.getConnection(url,  user, pwd);
		    stmt = conn.createStatement();
		    rs = stmt.executeQuery(query);
		    
		    while(rs.next()){
		    	data.put(rs.getString(columnName1),rs.getString(columnName2));
		    	
		    }
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			if(conn !=null){
				try{
					conn.close();
				}catch(Exception e){}
			}
		}
		return data;
	}


public static LinkedList<String> getRowsDataWithColumnName(String query, String columnName){
		
		Connection conn= null;
		Statement stmt = null;
		ResultSet rs = null;
		String columnData = null;
		LinkedList<String> data=new LinkedList<String>();
		try{
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			conn = DriverManager.getConnection(url,  user, pwd);
		    stmt = conn.createStatement();
		    rs = stmt.executeQuery(query);
		    
		    while(rs.next()){
		    	data.add(rs.getString(columnName));
		    	
		    }
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			if(conn !=null){
				try{
					conn.close();
				}catch(Exception e){}
			}
		}
		return data;
	}

public static void executeSelectQuery(String query){
Connection conn= null;
Statement stmt = null;
ResultSet rs = null;

try{
	
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	conn = DriverManager.getConnection(url,  user, pwd);
    stmt = conn.createStatement();
    rs = stmt.executeQuery(query);
    
}catch(SQLException e){
	e.printStackTrace();
}finally{
	if(conn !=null){
		try{
			conn.close();
		}catch(Exception e){}
	}
}		
}


public static List<BigDecimal> getColumnDataForWHDB(String query, String columnName,String url,String user,String pwd){
	
	Connection conn= null;
	Statement stmt = null;
	ResultSet rs = null;
	List<BigDecimal> columnData = new ArrayList<>();
	
	
	try{
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		conn = DriverManager.getConnection(url,  user, pwd);
	    stmt = conn.createStatement();
	    rs = stmt.executeQuery(query);
	    
	    while(rs.next()){
	    	columnData.add(rs.getBigDecimal(columnName));
	    	
	    }
	}catch(SQLException e){
		e.printStackTrace();
	}finally{
		if(conn !=null){
			try{
				conn.close();
			}catch(Exception e){}
		}
	}
	return columnData;
}




public static List<String> getColumnDataForItemMicroservice(String query, String columnName,String url,String user,String pwd){
	
	Connection conn= null;
	Statement stmt = null;
	ResultSet rs = null;
	List<String> columnData = new ArrayList<>();
	
	
	try{
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		conn = DriverManager.getConnection(url,  user, pwd);
	    stmt = conn.createStatement();
	    rs = stmt.executeQuery(query);
	    
	    while(rs.next()){
	    	columnData.add(rs.getString(columnName));
	    	
	    }
	}catch(SQLException e){
		e.printStackTrace();
	}finally{
		if(conn !=null){
			try{
				conn.close();
			}catch(Exception e){}
		}
	}
	return columnData;
}

public static String getFirstRowDataWithColumnName(String pUrl, String pUser, String pPwd, String query, String columnName){
	
	Connection conn= null;
	Statement stmt = null;
	ResultSet rs = null;
	String columnData = null;
	
	try{
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		conn = DriverManager.getConnection(pUrl, pUser, pPwd);
	    stmt = conn.createStatement();
	    rs = stmt.executeQuery(query);
	    
	    while(rs.next()){
	    	columnData = rs.getString(columnName);
	    	
	    }
	}catch(SQLException e){
		e.printStackTrace();
	}finally{
		if(conn !=null){
			try{
				conn.close();
			}catch(Exception e){}
		}
	}
	return columnData;
}

public static void UpdateData(String pUrl, String pUser, String pPwd, String query){
	
	Connection conn= null;
	Statement stmt = null;
	ResultSet rs = null;
	
	try{
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		conn = DriverManager.getConnection(pUrl, pUser, pPwd);
	    stmt = conn.createStatement();
	    stmt.executeUpdate(query);
	   
	}catch(SQLException e){
		e.printStackTrace();
	}finally{
		if(conn !=null){
			try{
				conn.close();
			}catch(Exception e){}
		}
	}
	
}
public static List<HashMap<String, Object>> getRowsDataWithColumnsListOfMaps(String pUrl, String pUser, String pPwd, String query, String action){
	
	List<HashMap<String, Object>> rows = new ArrayList<HashMap<String, Object>>();
	Connection conn= null;
	Statement stmt = null;
	ResultSet rs = null;
	int counter=0;
	
	try{
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		conn = DriverManager.getConnection(pUrl,  pUser, pPwd);
	    stmt = conn.createStatement();
	    rs = stmt.executeQuery(query);
	    
	    ResultSetMetaData md = rs.getMetaData();
	    int columns = md.getColumnCount();
	    
	    while (rs.next()){
	        HashMap<String, Object> row = new HashMap<String, Object>(columns);
	        for(int i = 1; i <= columns; ++i){
	            row.put(md.getColumnName(i), rs.getObject(i));
	        }
	        rows.add(row);
	        counter = counter + 1;
	        if (action.equalsIgnoreCase("getFirstRow") && counter>0) {
				break;
			}
	    }
	    
	}catch(SQLException e){
		e.printStackTrace();
	}finally{
		if(conn !=null){
			try{
				conn.close();
			}catch(Exception e){}
		}
	}
	return rows;
}

public static Map<String, String> getFirstRowDataWithColumnNamesForAnyDB(String pUrl, String pUser, String pPwd, String query, String... columnNames){
	//var-args
	Map<String, String> rowData = new HashMap<String, String>();

	Connection conn= null;
	Statement stmt = null;
	ResultSet rs = null;
	
	try{
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		conn = DriverManager.getConnection(pUrl,pUser, pPwd);
	    stmt = conn.createStatement();
	    rs = stmt.executeQuery(query);
	    
	    while(rs.next()){
	    	for(String columnLabel: columnNames){
	    		rowData.put(columnLabel, rs.getString(columnLabel));
	    	}
	    	break;
	    }
	}catch(SQLException e){
		e.printStackTrace();
	}finally{
		if(conn !=null){
			try{
				conn.close();
			}catch(Exception e){}
		}
	}
	return rowData;
}


}
