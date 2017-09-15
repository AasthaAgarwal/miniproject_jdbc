package main;

import java.util.Scanner;

import dao.EmployeeDao;

public class MainM {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("1. ADD RECORD \n 2. DELETE RECORD \n 3. DISPLAY_ALL RECORD \n 4. DISPLAY RECORD");

		byte b = s.nextByte();
		switch (b) {

		case 1: {
			EmployeeDao e = new EmployeeDao();
			System.out.println("Enter the Employee id");
			int EmpNo = s.nextInt();
			System.out.println("Enter First name of employee");
			String FirstName = s.next();
			System.out.println("Enter the last name of employee");
			String LastName = s.next();
			System.out.println("Enter the joindate");
			String JoinDate = s.next();
			System.out.println("Enter the Designation");
			String Designation = s.next();
			System.out.println("Enter the department");
			String Dept = s.next();
			System.out.println("enter basic salary");
			int BasicSalary = s.nextInt();
			System.out.println("enter the date of birth");
			String Dob = s.next();
			System.out.println("enter the qualification");
			String EducQual = s.next();
			System.out.println("enter the address");
			String address = s.next();
			System.out.println("enter the city");
			String City = s.next();
			System.out.println("enter the pin");
			String Pin = s.next();
			System.out.println("enter the phone no.");
			int Phone = s.nextInt();
			e.createEmployee(EmpNo, FirstName, LastName, JoinDate, Designation, Dept, BasicSalary, Dob, EducQual,
					address, City, Pin, Phone);
			break;
		}

		case 2: {
			EmployeeDao e = new EmployeeDao();
			System.out.println("enter the employee id:");
			int empNo = s.nextInt();
			System.out.println("do you want to delete the record...!!! press Y or n");
			String c = s.next();
			// String y;
			// String Y;
			if (c.equalsIgnoreCase("y")) {
				e.deleteEmployee(empNo);
				System.out.println("record deleted..!!!");
			}

			break;
		}
		case 3: {
			EmployeeDao e = new EmployeeDao();
			System.out.println("records diplayed...!!!");
			e.displayAll();
			break;
		}
		case 4: {
			EmployeeDao e = new EmployeeDao();
			int en = s.nextInt();
			System.out.println("record of empid-" + en + " is=");
			e.Display(en);

		}
		}

	}
}
