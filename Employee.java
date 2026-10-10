package classes;
import interfaces.*;

public class Employee extends Person 
{
	public String employeeType;
	public int employeeId;
	public String salary;

	public Employee(){System.out.println("\t\t\tNo Employees available");}
	public Employee(String name,String phoneNo,String employeeType,int employeeId,String salary)
	{
		super(name,phoneNo);
		this.employeeType=employeeType;
		this.employeeId=employeeId;
		this.salary=salary;
	}
	public void setEmployeeType(String employeeType)
	{
		this.employeeType=employeeType;
	}
	public String getEmployeeType(){return employeeType;}

	public void setEmployeeId(int employeeId)
	{
		this.employeeId=employeeId;
	}
	public int getEmployeeId(){return employeeId;}

	public void setSalary(String salary)
	{
		this.salary=salary;
	}
	public String getSalary(){return salary;}


}