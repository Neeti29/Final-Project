package Final_Project;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


	public class HRRole extends HR
	{
		
		PreparedStatement pstm;
		Statement stm;
		Connection con=	Createconnection.createConnection();
		Scanner s=new Scanner(System.in);
		
		void addNewEmployee() throws Exception
		{
			 System.out.println("Enter First Name");
			 String firstName=s.nextLine();
			 
			 System.out.println("Enter Last Name");
			 String lastName=s.nextLine();
			 
		     System.out.println("Enter DOB");
			 String dob=s.nextLine();
			 
			 System.out.println("Enter Gender");
			 String gender=s.nextLine();
			 
			 System.out.println("Enter Email ID");
			 String email_id=s.nextLine();
			 
			 System.out.println("Enter Phone Number");
			 String phone_number=s.nextLine();
			 
			 System.out.println("Enter Address");
			 String address=s.nextLine();
			 
			 System.out.println("Enter Skill Set");
			 String skills=s.nextLine();
			 
			 System.out.println("Enter Designation");
			 String designation=s.nextLine();
			 
			 System.out.println("Enter Salary");
			 int salary=s.nextInt();
			try
			{
				String query = " insert into employee (First_Name, Last_Name, DOB, Gender, Email_Id,Phone_Number, Address,Skills,Designation, Salary)"
				        + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				 
				// create the mysql insert preparedstatement
				
			      pstm = con.prepareStatement(query);
			      pstm.setString (1, firstName);
			      pstm.setString (2, lastName);
			      pstm.setDate(3, java.sql.Date.valueOf(dob));
			      pstm.setString(4,gender);
			      pstm.setString(5, email_id);
			      pstm.setString(6,phone_number);
			      pstm.setString(7,address);
			      pstm.setString(8,skills);
			      pstm.setString(9,designation); 
			      pstm.setInt(10, salary);
			   

			      // execute the preparedstatement
			      pstm.execute();
			      
			      con.close();
			}
			
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}

		}
		void updateDetails() throws Exception
		{
			//stmt = con.createStatement();
			
			try
			{
				
				String sqlUpdate="UPDATE department " + "SET Dept_Name=?" + "WHERE D_Id = ?";
				pstm=con.prepareStatement(sqlUpdate);
	            
				Scanner s=new Scanner(System.in);
				
				System.out.println("Enter Department ID:");
				int deptId=s.nextInt();  
				
				
				System.out.println("Enter new Department");
				System.out.println("Mee");
				String dept_name =s.next(); 
				
				pstm.setString(1,dept_name);
				pstm.setInt(2,deptId );
				
				int rowAffected=pstm.executeUpdate();
				System.out.println("Row Affected" + rowAffected);
				System.out.println("Updated Successfully");
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			
			
		}
		
		//Delete Operation
		void deleteDetails() throws Exception
		{
			try
			{

				System.out.println("Enter Department ID:");
				int deptId=s.nextInt();  
				//int i3= stmt.executeUpdate("Delete from Project where D_Id = 12");
				String sqlDelete = "DELETE FROM Project where D_ID = ?";
	            pstm = con.prepareStatement(sqlDelete);
				
				
				pstm.setInt(1, deptId);
				int del = pstm.executeUpdate();
				System.out.println("Number of deleted records: " + del);
				System.out.println("The Employee is released from the Project");
			
				
				System.out.println(" Success !!");
				
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			
			pstm.close();
			con.close();
			System.out.println("Connection is closed");
			
		}
		
		void updateDesignation() throws Exception
		{
			try{
				Connection con=	Createconnection.createConnection();
				Statement stmt=con.createStatement();  
				int sal=0;
				System.out.println("Enter employee id");
				int empId=s.nextInt();
				
				System.out.println("Enter new Employee Designation");
			    String newDesg=s.next();

				ResultSet rs=stmt.executeQuery("Select Salary from employee where E_Id= '"+ empId +"'" );
				
				while(rs.next())
				{
					sal=rs.getInt("Salary");
				}
				//System.out.println("********************"+sal);
				int updatedSal=sal+((sal*20)/100);
				System.out.println("****"+updatedSal);
				
				String sqlUpdate=("UPDATE employee  SET Salary = ?, Designation= ? WHERE E_Id = ?");
			   pstm=con.prepareStatement(sqlUpdate);
				
				pstm.setInt(1,updatedSal);
				pstm.setString(2, newDesg);
				pstm.setInt(3, empId);
				pstm.executeUpdate();
				System.out.println("Salary updated for the Employee and employee gets prompoted");
				
				con.close();
			}
			
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		
		/*	System.out.println("Enter employee id");
			String empId=s.nextLine();
			int sal;
			
			int salary="Select Salary from employee where E_Id="+empId;
			rs.get
			
			System.out.println("Enter new Employee Designation");
			String desg=s.nextLine();
			
			
				int updatedSal=Salary+(Salary*20)/100;
				String sqlUpdate="UPDATE employee " + "SET Salary =updatedSal and Designation=desg" + "WHERE E_Id = empId";  */
		}
		
		void viewEmployeeDetails() throws Exception
		{
			try
			{
				Connection con=	Createconnection.createConnection();
				Statement stmt=con.createStatement();  
				ResultSet rs=stmt.executeQuery("Select * from employee e INNER JOIN department d on e.E_Id=d.E_Id");
				System.out.println("Neeti"+stmt);
				while(rs.next())
				{
					/*System.out.println(rs.getInt(1)+ " " +rs.getString(2)+ " " + rs.getString(3) + " " + rs.getDate(4) + " "+ rs.getCharacterStream(5) + " "+rs.getString(6)+ " " +rs.getString(7)+ " "+ rs.getString(8)+ " "+rs.getInt(9)+ " "+rs.getBlob(10));  */
					
					System.out.println(rs.getInt("E_Id")+ " " +rs.getString("First_Name")+ " " + rs.getString("Dept_Name"));
				}
				con.close();
			}
			
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}



