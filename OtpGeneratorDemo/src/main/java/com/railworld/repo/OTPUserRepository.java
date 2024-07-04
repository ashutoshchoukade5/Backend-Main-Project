package com.railworld.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.railworld.Entity.OtpUser;

@Repository
public interface OTPUserRepository  extends JpaRepository<OtpUser, String>{

	OtpUser findByMobileNumberAndOtp(String mobileNumber, String otp);

	OtpUser findByMobileNumber(String mobileNumber);
	

}
