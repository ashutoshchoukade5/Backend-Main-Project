package com.railworld.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="twilio")
public class OTPConfig {
	private String accountSid;
	private String autnToken;
	private String phoneNumber;
	public String getAccountSid() {
		return accountSid;
	}
	public void setAccountSid(String accountSid) {
		this.accountSid = accountSid;
	}
	public String getAutnToken() {
		return autnToken;
	}
	public void setAutnToken(String autnToken) {
		this.autnToken = autnToken;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	

}
