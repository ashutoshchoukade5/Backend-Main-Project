package com.tka.MainBankEmployee;

import com.tka.Employee.Employee1;
import com.tka.EmployeeInfo.EmployeeDetail;

public class MainEmployeeAcc {

	public static void main(String[] args) {
		
	EmployeeDetail ED = new EmployeeDetail();
	Employee1 obj =ED.createEmployeeObject();
	
	
	char BankName=obj.getBankName();
	String name = obj.getname();
	String Address = obj.getAddress();
	double amount = obj.getamount();
	int AccNo = obj.getAccNo();
	long IFCcode = obj.getIFCcode();
	float date = obj.getdate();
	
	System.out.println("Bank Name = " +BankName+ " Reserve Bank OF India ");
	System.out.println("===============");
	System.out.println("Bank Of INDIA");
	System.out.println("Name Of Employee =  "+name);
	System.out.println("Address in Deatil =  " +Address);
	System.out.println("Saving Amount in RS =  "+amount+"Thousand RS");
	System.out.println("Employee Account Number =  "+AccNo);
	System.out.println("Employee IFC CODE =  "+IFCcode);
	System.out.println("Date of Issue =  "+ "Feb"+date);
	
	}

}
