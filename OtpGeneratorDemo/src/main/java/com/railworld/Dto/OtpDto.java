package com.railworld.Dto;

import lombok.Data;

@Data
public class OtpDto {
 private String userId;
 private String email;
 private String mobileNumber;
 private String otp;
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public String getEmailId() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
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
 public void setError(String invalidOtpOrMobileNumber) {
	 

}
}
