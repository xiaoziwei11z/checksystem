package com.dn.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.*;

public class CheckImpl extends UnicastRemoteObject implements Check {

	protected CheckImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void checkNumber(int classNumber, String currentNumber, String havingNumber, int yearNumber, int monthNumber,
			int dayNumber) throws Exception {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/education?serverTimezone=GMT","root","qazwow1998");
		Statement stmt = con.createStatement();
		stmt.executeUpdate("INSERT INTO checkrecords "
				+ "VALUES(" + classNumber +"," + Integer.parseInt(currentNumber)
				 + "," + Integer.parseInt(havingNumber) + ",'"
				 + yearNumber + "-" + monthNumber + "-" + dayNumber + "')");
		stmt.close();
		con.close();
	}

}
