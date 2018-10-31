package com.dn.server;

import java.rmi.Remote;
import java.sql.SQLException;

public interface Check extends Remote {
	public void checkNumber(int classNumber,String currentNumber,String havingNumber,
			int yearNumber,int monthNumber,int dayNumber) throws Exception;
}
