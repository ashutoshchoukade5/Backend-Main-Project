package com.railworld.Entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;

import org.springframework.data.annotation.Id;


@Entity
public class OtpUser {
	private String userId;
	@Id
	private String mobileNumber;
	private String otp;
	private String email;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDateTime getExpirationTime() {
		return expirDateTime;	
	}
	public void setExpirationTime(LocalDateTime expirationTime) {
		this.expirDateTime=expirationTime;
		
	}
	private LocalDateTime expirDateTime;
	

}
