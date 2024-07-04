package com.tka.Employee;

public class Employee1 {
	public char BankName;
	public String name;
	public String Address;
	public double amount;
	public int AccNo;
	public long IFCcode; 
	public float date;
	
	public Employee1() {
		
	}
	public Employee1(char BankName, String name, String Address, double amount, int AccNo, long IFCcode, float date) {
		this.BankName=BankName;
		this.name=name;
		this.Address=Address;
		this.amount=amount;
		this.AccNo=AccNo;
		this.IFCcode=IFCcode;
		this.date=date;
		}
	
    public char getBankName() {
	return this.BankName;
}
	public void setBankNmae(char BnakName) {
		this.BankName=BankName;
		}
    public String getname() {
	return this.name;
}
	public void setnmae(String name) {
		this.name=name;
		}
public String getAddress() {
	return this.Address;
}
	public void setAdress(String Address) {
		this.Address=Address;
		
	}
	
	public double  getamount() {
	return this.amount;
}
	public void setamount(double amount) {
		this.amount=amount;
		
		}
	
    public int getAccNo() {
	return this.AccNo;
}
	public void setAccNo(int AccNo) {
		this.AccNo=AccNo;
		}
	
	public long getIFCcode() {
	return this.IFCcode;
}
	public void setIFCcode(long IFCcode) {
		this.IFCcode=IFCcode;
	}
	public float getdate() {
	return this.date;
}
	public void setdate(float date) {
		this.date=date;
		
	}
	}