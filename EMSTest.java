package Final_Project;
import java.util.Scanner;
public class EMSTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Scanner s=new Scanner(System.in);
	
		System.out.println("Welcome to EMPLOYEE MANAGEMENT SYSTEM");
		System.out.println("1.Employee\n"+ "2.HR\n");
		int choice=s.nextInt();
		
		//int ch1;
		if(choice==1)
		{
			System.out.println("Employee Login");
			System.out.println("Press 1 for View Details\n");
			System.out.println("Press 2 for view other employee details");
		
			EmployeeDetails eObj=new EmployeeDetails();
			System.out.println("Enter Choices for Employee");
			int ch=s.nextInt();
		
		
		
			do
			{
			
			
			switch(ch)
			{
			case 1:
			{
				eObj.viewDetails();
				break;
			}
			case 2:
			{
				eObj.viewOtherEmployee();
			}
		}
				
				
			}while(ch!=2);
			
		}
		
		else
				
		{
			do
			{
				
			
				System.out.println("HR Login");
				System.out.println("Press 1 to Add New Employee");
				System.out.println("Press 2 for Viewing Employee Details");
				System.out.println("Press 3 for Update");
				System.out.println("Press 4 for Delete");
				System.out.println("Press 5 for Updating the designation of an Employee");
				
				HRRole hObj=new HRRole();
				System.out.println("Enter Choices for HR");
				ch1=s.nextInt();
				
				switch(ch)
				{
				
					case 1:
					{
						
						hObj.addNewEmployee();
						break;
					}
					
					case 2:
					{
						
						hObj.updateDetails();
						break;
					}
					
					case 3:
					{
						
						hObj.deleteDetails();
						break;
					}
					case 4:
					{
						
						hObj.updateDesignation();
						break;
					}
				}
			
			}
			while(ch1!=4);
			
		}
		 
	}
	
}	
