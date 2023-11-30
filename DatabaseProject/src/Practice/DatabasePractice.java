package Practice;

import java.sql.*;

public class DatabasePractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null ;
		method(); 
		try {
			//Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		}
		catch(ClassNotFoundException ex){
			System.out.println("Problem in loading the driver");
			ex.printStackTrace();
		}
		
		try {
			String dbName = "Employee.accdb";
			String dbURL = "jdbc:ucanaccess://" + dbName;
			conn = DriverManager.getConnection(dbURL);
			stat = conn.createStatement();
			String query;
//			String query = "INSERT INTO EMP (Name, Salary)" + "value ('ABC',9500)";
//			stat.executeUpdate(query);
			query = "UPDATE EMP SET SALARY = 12000 " + "where EName = 'Kim'";
			stat.executeUpdate(query);
			rs = stat.executeQuery("SELECT * FROM EMP");
			
			int id;
			String name;
			double sal;
			while(rs.next()) {
				id = rs.getInt(1);
				name = rs.getString(2);
				sal = rs.getDouble(3);
				System.out.println("Id " + id + " Name " + name + " Salary " + sal);
			}
		}
		catch(SQLException ex) {
			System.out.println("Problem with database");
		}
		finally {
			try {
				if(conn!=null) {
					rs.close();
					stat.close();
					conn.close();
				}
			}
			catch(SQLException ex) {
				ex.printStackTrace();
			}
		}

	}

	public static void method() 
	{
		System.out.println("This is a method");
	}
}
