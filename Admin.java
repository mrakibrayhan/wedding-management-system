package classes;
import interfaces.*;

public class Admin implements EmployeeOperations,Team
{
	public static String adminId="admin";
	public static String password="12345";
	public boolean temp=false;
	public static Employee employees[]=new Employee[30];
	public static Client clients[]=new Client[30];
	
	public Admin(){}
	public Admin(String adminId, String password)
	{
		
			if((!this.adminId.equals(adminId)) || (!this.password.equals(password)))
		{
			temp=false;
			System.out.println("\t\t/////WRONG PASSWORD!/////");
		}
		else{temp=true;}
	}

	public void addEmployee(Employee emp)
	{
		int flag=0;
		//try {
			for(int i=0;i<employees.length;i++)	
		{
			if(employees[i]== null)
			{
			employees[i]=emp;
			flag=1;
			break;
			}
			
		}
			
			
		
		if(flag==1)
		{
			System.out.println("\t\t\tEmployee added");
		}
		else
		{
			System.out.println("\t\t\toops!! Couldn't Add Employee");
		}
			//}
		/*catch(Exception e)
			{
				System.out.println("Exception Occurred");
			}*/	
	}

	public void removeEmployee(int id)
	{
		int flag=0;
		/*try{*/
			for(int i=0;i<employees.length;i++)
		{
			if (employees[i].employeeId==id)
			{
				employees[i]=null;
				flag=1;
				break;
				
			}

		}

		if(flag==1)
		{
			System.out.println("\t\t\tEmployee Removed");
		}else
		{
			System.out.println("\t\t\toops!! Couldn't Remove Employee");
		}
		
			/*} catch(Exception e)
			{
				System.out.println("\t\t------No Employee having this ID-------");
			}*/
		
	}

	public void showEmployees()
	{
		
        for(int i=0;i<employees.length;i++)
		{
			if (employees[i]!=null)
			{
				System.out.println("\t\t\tEmployee Name : "+employees[i].getName());
				System.out.println("\t\t\tEmployee Phone Number : "+employees[i].getPhoneNo());
				System.out.println("\t\t\tEmployee Type : "+employees[i].getEmployeeType());
				System.out.println("\t\t\tEmployee Id : "+employees[i].getEmployeeId());
				System.out.println("\t\t\tSalary : "+employees[i].getSalary());
				System.out.println("\t\t\t.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.");
			}
		}
	}



	
	public void createTeam(int teamno,int a,int b)
	{
		
		
		for(int i=0;i<employees.length;i++)
		{
			
			if(employees[i]!=null)
			{
			if(employees[i].employeeId==a)
				{
				System.out.println("\t\t----ID Number "+a+" added to the team "+teamno+"----");
				System.out.println("\t\t\tFirst Employee Name : "+employees[i].getName());
				System.out.println("\t\t\tFirst Employee Phone Number : "+employees[i].getPhoneNo());
				System.out.println("\t\t\tFirst Employee Type : "+employees[i].getEmployeeType());
				System.out.println("\t\t\tFirst Employee Id : "+employees[i].getEmployeeId());
				
				}
			}
		}
		for(int j=0;j<employees.length;j++)
		{
			if(employees[j]!=null)
			{
			if(employees[j].employeeId==b)
				{
				System.out.println("\t\t----ID Number "+b+" added to the team "+teamno+"----");
				System.out.println("\t\t\tSecond Employee Name : "+employees[j].getName());
				System.out.println("\t\t\tSecond Employee Phone Number : "+employees[j].getPhoneNo());
				System.out.println("\t\t\tSecond Employee Type : "+employees[j].getEmployeeType());
				System.out.println("\t\t\tSecond Employee Id : "+employees[j].getEmployeeId());
				
				}
			}
		}
		

	}
	

}