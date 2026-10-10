package interfaces;
import classes.Employee;

public interface EmployeeOperations
{
	public abstract void addEmployee(Employee emp);
	void removeEmployee(int id);
	void showEmployees();
}