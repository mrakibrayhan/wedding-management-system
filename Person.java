package classes;

public class Person 
{
	protected String name;
	protected String phoneNo;
	public Person(){}
	public Person(String name,String phoneNo)
	{
		this.name=name;
		this.phoneNo=phoneNo;
	}

	public void setName(String name)
	{
		this.name=name;
	}
	public String getName(){return name;}

	public void setPhoneNo(String phoneNo)
	{
		this.phoneNo=phoneNo;
	}
	public String getPhoneNo(){return phoneNo;}

}