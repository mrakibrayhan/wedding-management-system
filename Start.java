
import java.util.Scanner;
import classes.*;
import java.io.*;
import interfaces.*;
import fileio.*;

public class Start {
	public static void main(String args[]) {

		// MAIN:
		Scanner scanner = new Scanner(System.in);

		// Define arrays to store usernames and passwords
		String[] usernames = new String[100]; // Assuming a maximum of 100 users
		String[] passwords = new String[100];
		int userCount = 0;
		boolean flag = true;

		while (true) {
			System.out.println("				#Welcome to the Simple Login System#");
			System.out.println("         1. Register");
			System.out.println("         2. Login");
			System.out.println("         3. Exit");
			System.out.print("    Please choose an option: ");

			int choice = scanner.nextInt();
			scanner.nextLine(); // Consume the newline

			switch (choice) {
			case 1:
				registerUser(usernames, passwords, userCount, scanner);
				userCount++;
				break;
			case 2:
				loginUser(usernames, passwords, userCount, scanner);
				break;
			case 3:
				System.out.println("Goodbye!");
				System.exit(0);
			default:
				System.out.println("Invalid choice. Please select a valid option.");
			}
		}
	}

	public static void registerUser(String[] usernames, String[] passwords, int userCount, Scanner scanner) {
		System.out.print("  Enter your Username: ");
		String username = scanner.nextLine();

		// Check if the username already exists
		for (int i = 0; i < userCount; i++) {
			if (usernames[i].equals(username)) {
				System.out.println("  Username already exists. Please choose a different one.");
				return;
			}
		}

		System.out.print("  Enter your password: ");
		String password = scanner.nextLine();

		// Store the username and password
		usernames[userCount] = username;
		passwords[userCount] = password;

		System.out.println("Registration successful. You can now log in.");
	}

	public static void loginUser(String[] usernames, String[] passwords, int userCount, Scanner scanner) {
		System.out.print("  Enter your username: ");
		String username = scanner.nextLine();
		boolean flag = true;
		// Find the user's index by username
		int userIndex = -1;
		for (int i = 0; i < userCount; i++) {
			if (usernames[i].equals(username)) {
				userIndex = i;
				break;
			}
		}

		if (userIndex != -1) {
			System.out.print("  Enter your password: ");
			String password = scanner.nextLine();

			// Check if the entered password matches the stored password
			if (passwords[userIndex].equals(password)) {
				System.out.println("Login successful. Welcome, " + username + "!");
			} else {
				System.out.println("Incorrect password. Please try again.");
				return;
			}
		} else {
			System.out.println("Username not found. Please register first.");
			return;
		}

		try {
			while (true) {

				System.out.println("\n\t\t\t\"Welcome to Wedding Management System\"");
				System.out.println("\t\t1. Admin");
				System.out.println("\t\t2. Client");
				System.out.println("\t\t3. Exit");
				System.out.print("Enter Your Choice = ");
				int mainInput = scanner.nextInt();

				switch (mainInput) {
				case 1:
					System.out.println("");
					System.out.print("Enter ADMIN Name = ");
					String adminId = scanner.next();
					System.out.print("Enter ADMIN Password = ");
					String password = scanner.next();

					ClientFileReadWrite cfrw = new ClientFileReadWrite();

					Admin a1 = new Admin(adminId, password);
					if (a1.temp == false) {
						break;
					}

					else {
						ADMIN: try {
							while (true) {
								System.out.println("\n\t\t1. Add Employee");
								System.out.println("\t\t2. Remove Employee");
								System.out.println("\t\t3. Show Employees");
								System.out.println("\t\t4. Create A Team");

								System.out.println("\t\t0. Exit To Main Menu");
								System.out.print("Enter Choice = ");
								int adminInput = scanner.nextInt();
								Scanner sc = new Scanner(System.in);

								try {
									switch (adminInput) {

									case 1:
										System.out.println("\nEnter Employee Name : ");
										String name = sc.next();
										System.out.println("\nEnter Employee Phone Number : ");
										String phoneNo = sc.next();
										System.out.println("\nChoose Employee Type : ");// edited
										// String employeeType=sc.next();
										System.out.println("     1. Part-Time");
										System.out.println("     2. Full-Time");
										System.out.print("Enter choice for the employee type: ");
										int employeeTypeChoice = sc.nextInt();
										String employeeType = "";

										if (employeeTypeChoice == 1) {
											employeeType = "Part-Time";
										} else if (employeeTypeChoice == 2) {
											employeeType = "Full-Time";
										} else {
											System.out.println(
													"Invalid choice. Setting employee type to Part-Time by default.");
											employeeType = "Part-Time";
										} // upto this
										EmployeeFileReadWrite efrw = new EmployeeFileReadWrite();

										System.out.print("\nEnter Employee ID : ");
										int employeeId = sc.nextInt();
										System.out.print("\nEnter Employee Salary : ");
										String salary = sc.next();
										Employee e1 = new Employee(name, phoneNo, employeeType, employeeId, salary);
										a1.addEmployee(e1);
										efrw.writeInFile("===============================");
										efrw.writeInFile("Employee Name   : " + e1.getName());
										efrw.writeInFile("Employee Number : " + e1.getPhoneNo());
										efrw.writeInFile("Employee Type   : " + e1.getEmployeeType());
										efrw.writeInFile("Employee ID     : " + String.valueOf(e1.getEmployeeId()));
										efrw.writeInFile("Employee Salaray: " + e1.getSalary());
										break;

									case 2:
										System.out.print("Enter Employee Id to remove : ");
										int iid = sc.nextInt();
										a1.removeEmployee(iid);

										break;

									case 3:

										a1.showEmployees();

										break;

									case 4:
										System.out.print("\nEnter Team Number : ");
										int tnum = sc.nextInt();
										System.out.print("\nEnter First employee ID : ");
										int em1Id = sc.nextInt();
										System.out.print("\nEnter Second employee ID : ");
										int em2Id = sc.nextInt();
										a1.createTeam(tnum, em1Id, em2Id);
										break;

									case 0:
										break ADMIN;

									}
								} catch (Exception e) {
									System.out.println("Exception Occurred");
								}
							}
						} catch (Exception e) {
							System.out.println("Exception Occurred");
						}
						break;
					}

				case 2:
					ClientFileReadWrite cfrw1 = new ClientFileReadWrite();
					Scanner sk = new Scanner(System.in);
					CLIENT: while (true) {
						System.out.println("\n\t\t\t*****Welcome to Wedding Planner*****");
						System.out.print("\tEnter your name : ");
						String name = sk.next();
						System.out.print("\tEnter your Phone No : ");
						String phoneNo = sk.next();
						System.out.print("\tEnter your Email : ");
						String email = sk.next();
						System.out.print("\tEnter your  NId : ");
						String clientNId = sk.next();
						Client c1 = new Client(name, phoneNo, email, clientNId);
						cfrw1.writeInFile("===============================");
						cfrw1.writeInFile("Client Name   : " + c1.getName());
//						 cfrw1.readFromFile();
						cfrw1.writeInFile("Client Number : " + c1.getPhoneNo());
//						 cfrw1.readFromFile();
						cfrw1.writeInFile("Client Email  : " + c1.getEmail());
//						 cfrw1.readFromFile();
						cfrw1.writeInFile("Client NID    : " + c1.getClientNId());
//						 cfrw1.readFromFile();
						Dhaka dhaka = new Dhaka();
						Chattogram chattogram = new Chattogram();
						Sylhet sylhet = new Sylhet();

						while (true) {
							Scanner sc = new Scanner(System.in);
							B: System.out.print("Enter your Budget: ");
							int budget = sc.nextInt();
							PACKAGE:

							if (budget >= 200000) {
								while (true) {

									System.out.println("Welcome to Wedding Management System");
									System.out.println("Select a Region:");
									System.out.println("1. Dhaka");
									System.out.println("2. Chattogram");
									System.out.println("3. Sylhet");

									System.out.print("\tEnter Your Choice : ");
									int regionChoice = sc.nextInt();
									int photographerCost = 50000;

									switch (regionChoice) {
									case 1:

										int k1 = dhaka.manageWedding();
										System.out.println(
												"\t\t*Do you want to add photographer ? \n\t\t-If you want to add PRESS 1 and If you don't PRESS any Number key");
										int phInput1 = sc.nextInt();
										if (phInput1 == 1) {

											int p1 = photographerCost + k1;
											cfrw1.writeInFile("Total Cost  :"+p1+" Taka");
											c1.clientDetails();
											System.out.println("\t\t\tTotal cost:" + p1 + "TK");
											System.out.println(" ");
											System.out.print("\t\t\t*****Your Registration Confirmed*****");
											System.out.println(" ");

											break CLIENT;

										} else {
											c1.clientDetails();
											System.out.println("\t\t\tTotal cost:" + k1 + "TK");
											System.out.println(" ");
											System.out.print("\t\t\t*****Your Registration Confirmed*****");
											System.out.println(" ");
											break CLIENT;
										}

									case 2:

										int k2 = chattogram.manageWedding();
										System.out.println(
												"\t\t*Do you want to add Photographer ? \n\t\t-If you want to add PRESS 1 and If you don't, PRESS any Number key");
										int phInput2 = sc.nextInt();
										
										if (phInput2 == 1) {

											int p2 = photographerCost + k2;
											cfrw1.writeInFile("Total Cost  :"+p2+" Taka");
											c1.clientDetails();
											System.out.println("\t\t\tTotal cost:" + p2 + "TK");
											System.out.println(" ");
											System.out.print("\t\t\t*****Your Registration Confirmed*****");
											System.out.println(" ");

											break CLIENT;

										} else {
											c1.clientDetails();
											System.out.println("\t\t\tTotal cost:" + k2 + "TK");
											System.out.println(" ");
											System.out.print("\t\t\t*****Your Registration Confirmed*****");
											System.out.println(" ");
											break CLIENT;
										}

									case 3:
										int k3 = sylhet.manageWedding();
										System.out.println(
												"\t\t*Do you want to add Photographer ? \n\t\t-If you want to add PRESS 1 and If you don't, PRESS any Number key");
										int phInput3 = sc.nextInt();
										if (phInput3 == 1) {

											int p3 = photographerCost + k3;
											cfrw1.writeInFile("Total Cost  :"+p3+" Taka");
											c1.clientDetails();
											System.out.println("\t\t\tTotal cost:" + p3 + "TK");
											System.out.println(" ");
											System.out.print("\t\t\t*****Your Registration Confirmed*****");
											System.out.println(" ");

											break CLIENT;

										} else {
											c1.clientDetails();
											System.out.println("\t\t\tTotal cost:" + k3 + "TK");
											System.out.println(" ");
											System.out.print("\t\t\t*****Your Registration Confirmed*****");
											System.out.println(" ");
											break CLIENT;
										}

									}

								}

							} else

							{
								break PACKAGE;

							}
							try {
								if (budget < 200000) {
									throw new InvalidBudget("sorry!! You haven't enough Budget");

								}

							} catch (InvalidBudget e) {
								System.out.println(e);
								System.out.println("Try again with valid budget");
								System.out.println();
							}

						}
						
					}
					break;
				case 3:
					System.exit(0);
					
			
				}

			}

		} catch (

		Exception e) {
			System.out.println("Exception Occurred");
		}

	}
}