package fileio;
import java.io.*;



public class EmployeeFileReadWrite
{
	public File file;
	public FileWriter writer;
	public FileReader reader;
	public BufferedReader bfr;

	public void writeInFile(String s)
	{
		try
		{
			file=new File("EmployeeHistory.txt");
			file.createNewFile();
			writer=new FileWriter(file,true);
			writer.write(s+"\r"+"\n");
			writer.flush();
			writer.close();
		}
		catch(IOException ioe)
		{
			System.out.println("IO Exception Occurred");
		}}

		public void readFromFile()
		{
			try
			{
				reader=new FileReader(file);
				bfr=new BufferedReader(reader);
				String text=" ",temp;

				while((temp=bfr.readLine())!=null)
				{
					text=text+temp+"\n"+"\r";
				}
				System.out.print(text);
				reader.close();
			}
			catch(IOException ioe)
			{
				System.out.print("IO Exception Occurred");
			}
		}
	
}