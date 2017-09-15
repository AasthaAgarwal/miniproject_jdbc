package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import mp.MyConnection;

public class EmployeeDao {
	Connection con = MyConnection.getConnection();

	public String createEmployee(int EmpNo, String FirstName, String LastName, String JoinDate, String Designation,
			String Dept, int BasicSalary, String Dob, String EducQual, String address, String City, String Pin,
			int Phone)

	{

		try {
			con.setAutoCommit(false);

			PreparedStatement ps = con.prepareStatement("insert into employee_table values(?,?,?,?,?,?,?)");
			ps.setInt(1, EmpNo);
			ps.setString(2, FirstName);
			ps.setString(3, LastName);
			ps.setString(4, JoinDate);
			ps.setString(5, Designation);
			ps.setString(6, Dept);
			ps.setInt(7, BasicSalary);
			int a = ps.executeUpdate();
			if (a > 0)
				System.out.println("data entered..!!!");
			else
				System.out.println("data not entered..!!");
			PreparedStatement p = con.prepareStatement("insert into employee_personal_info values(?,?,?,?,?,?,?)");
			p.setString(1, Dob);
			p.setString(2, EducQual);
			p.setString(3, address);
			p.setString(4, City);
			p.setString(5, Pin);
			p.setInt(6, Phone);
			p.setInt(7, EmpNo);
			int b = p.executeUpdate();
			if (b > 0) {
				con.commit();
				return "full info entered in database";
			} else
				return "data not saved. \n Please enter correct information....!!!";

		} catch (SQLException e) {
			e.printStackTrace();
			return "error in updation..!!" + e;
		}

	}

	public String deleteEmployee(int empNo)

	{
		try {
			PreparedStatement ps = con.prepareStatement("select EmpNo from employee_table where Empno= ?");
			ps.setInt(1, empNo);

			ResultSet rs = ps.executeQuery();
			if (rs.next() == false)
				return "no such employee record!!!";
			else {
				PreparedStatement ps2 = con.prepareStatement("delete from employee_table  where Empno= ?");
				ps2.setInt(1, empNo);
				int i = ps2.executeUpdate();
				if (i > 0)
					return "delete record..!!";
				else
					return "record not deleted..!!";

			}
		} catch (SQLException e) {

			e.printStackTrace();
			return "error in deletion..!!" + e;
		}

	}

	public void displayAll() {
		Statement s1, s2;
		ResultSet rs1, rs2;
		try {
			s1 = con.createStatement();
			s2 = con.createStatement();
			rs1 = s1.executeQuery("select * from employee_table ");
			rs2 = s2.executeQuery("select dob from employee_personal_info");
			System.out.println("Emp ID Full Name Date of Birth Designation Department Net Salary");
			while (rs1.next() && rs2.next()) {
				System.out.println(rs1.getInt(1) + " " + rs1.getString(2) + " " + rs1.getString(3) + " "
						+ rs2.getString(1) + " " + rs1.getString(5) + " " + rs1.getString(6) + " " + rs1.getInt(7));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public String Display(int en) {
		try {
			PreparedStatement stmt = con.prepareStatement("select * from employee_table where EmpNo=?");
			stmt.setInt(1, en);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4)
						+ " " + rs.getString(5) + " " + rs.getString(6) + " " + rs.getInt(7));
			}
			return "record displayed..!!";
		} catch (SQLException e) {
			e.printStackTrace();
			return "error..!!" + e;
		}

	}

}
