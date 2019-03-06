package Final_Project;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import Project.Createconnection;

public class EmployeeDetails extends Employee {

	void viewDetails()  throws Exception
	{
		try
		{
			Connection con=	Createconnection.createConnection();
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("Select * from employee e INNER JOIN department d on e.E_Id=d.E_Id");

			while(rs.next())
			{
				/*System.out.println(rs.getInt(1)+ " " +rs.getString(2)+ " " + rs.getString(3) + " " + rs.getDate(4) + " "+ rs.getCharacterStream(5) + " "+rs.getString(6)+ " " +rs.getString(7)+ " "+ rs.getString(8)+ " "+rs.getInt(9)+ " "+rs.getBlob(10));  */
				
				System.out.println(rs.getInt("E_Id")+ " " +rs.getString("First_Name")+ " " + rs.getString("Last_Name")+ " "+ rs.getDate("DOB")+ " "+ rs.getString("Gender")+ " "+ rs.getString("Email_Id")+ " " + rs.getString("Pass")+ " "+ rs.getString("Conf_Pass")+ " "+ rs.getString("Phone_Number")+ " " + rs.getString("Address")+ " " + rs.getString("Skills")+ " "+ rs.getString("designation")+ " " + rs.getInt("Salary")+ " " + rs.getString("Dept_Name"));
				
			}
			con.close();
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	void viewOtherEmployee() throws Exception
	{
		try
		{
			Connection con=	Createconnection.createConnection();
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("Select * from employee e INNER JOIN department d on e.E_Id=d.E_Id");

			while(rs.next())
			{
				/*System.out.println(rs.getInt(1)+ " " +rs.getString(2)+ " " + rs.getString(3) + " " + rs.getDate(4) + " "+ rs.getCharacterStream(5) + " "+rs.getString(6)+ " " +rs.getString(7)+ " "+ rs.getString(8)+ " "+rs.getInt(9)+ " "+rs.getBlob(10));  */
				
				System.out.println(rs.getString("First_Name")+ " " + rs.getString("Last_Name")+ " "+ rs.getString("Gender")+ " "+ rs.getString("Email_Id")+ " " +rs.getString("Skills")+ " "+ rs.getString("designation")+ " " +rs.getString("Dept_Name"));
				
			}
			con.close();
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	}

