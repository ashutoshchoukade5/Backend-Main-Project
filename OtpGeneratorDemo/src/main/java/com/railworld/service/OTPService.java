package com.railworld.service;

import java.time.LocalDateTime;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.encrypt.BytesEncryptor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.railworld.Dto.OtpDto;
import com.railworld.Entity.OtpUser;
import com.railworld.config.OTPConfig;
import com.railworld.repo.OTPUserRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class OTPService {
	private final String key="aG9sYXNxdWVzdGVkVGzdFN0cmluZ1RoaXMgaXMgYSBzdHJpbmcga2V%IGF";
	
	private final BytesEncryptor encryptor = null;
	private static Object OTP_EXPIRATION_DELAY_MINUTES=120000;

	@Autowired
	private OTPConfig otpConfig;
	Map<String,String>otpMap=new HashMap<>();
	
	
	@Autowired 
	private OTPUserRepository otpUserRepository;
	@Autowired
	private JavaMailSender emailSender;
	
	
	
	
	

	private String encryptUserId(String userId) {
		byte[] encryptedBytes=encryptor.encrypt(userId.getBytes());
		
		
		return Base64.getEncoder().encodeToString(encryptedBytes);
	}

	private String decryptUserId(String encryptUserId) {
		byte[] decryptedBytes=encryptor.decrypt(Base64.getDecoder().decode(encryptUserId));
		
		
		return  new String(decryptedBytes);
	}

	private void scheduleDeleteTask(OtpUser otpUser, int deleyMinutes) {
		Executors.newSingleThreadScheduledExecutor().schedule(()->{
			otpUserRepository.delete(otpUser);
			otpUser.setOtp("0");
			OtpUser user= otpUserRepository.findByMobileNumber(otpUser.getMobileNumber());
			otpUser.setUserId(user.getUserId());
			otpUserRepository.save(otpUser);	
		},
				deleyMinutes,TimeUnit.MINUTES);
		
		
	}
	private String generateRandomUserID() {
		// TODO Auto-generated method stub
		return null;
	}



	public OtpDto generateOtp(OtpDto otpDto) {
		String otp=generateRandomOTP();
		LocalDateTime expirationTime=LocalDateTime.now().minusMinutes(2);
		OtpUser otpUser=new OtpUser();
		otpUser.setMobileNumber(otpDto.getMobileNumber());
		otpUser.setEmail(otpDto.getEmailId());
		otpUser.setOtp(otp);
		otpUser.setExpirationTime(expirationTime);
         otpUserRepository.save(otpUser);
         sendOtpSms(otpDto,otp);
         sendEmail(otpDto,otp,otpDto.getEmailId());
         scheduleDeleteTask(otpUser,2);
         
         // creating response with DTO
         OtpDto responseDTO=new OtpDto();
         responseDTO.setOtp(otp);
         responseDTO.setMobileNumber(otpUser.getMobileNumber());
         responseDTO.setEmail(otpUser.getEmail());
         return responseDTO;
		
	
	}
  // method   for generate random numeric otp in 6 digit
	private String generateRandomOTP() {
		Random random=new Random();
		int otp=100000+random.nextInt(900000);// Generate a random number between 100000 and 999999
		return String.valueOf(otp);
	}
	
	public OtpDto validateOTP(OtpDto requestDTO) {
		OtpUser otpUser=otpUserRepository.findByMobileNumberAndOtp(requestDTO.getMobileNumber(),requestDTO.getOtp());
		OtpDto responseDTO =new OtpDto();
		if(otpUser!=null) {
			String userId=generateRandomUserID();
			OtpUser updateUser=new OtpUser();// create a new OTpUser object  with Update userID
			PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
			updateUser .setUserId(userId);
			sendWhatsAPPMassage(requestDTO,userId);
			updateUser.setMobileNumber(otpUser.getMobileNumber());
			updateUser.setEmail(otpUser.getEmail());
			 
			otpUserRepository.save(updateUser);
			responseDTO.setUserId(encryptUserId(userId));
			responseDTO.setMobileNumber(otpUser.getMobileNumber());
			responseDTO.setEmail(otpUser.getEmail());	
		}
		else 
		{
			responseDTO.setError("Invalid OTP or mobile number or emailid");
		}
		return requestDTO;
		
		
	}
	
	private void sendOtpSms(OtpDto otpDto, String otp) {
		PhoneNumber to=new PhoneNumber(otpDto.getMobileNumber());
		PhoneNumber from=new PhoneNumber(otpConfig.getPhoneNumber());
		String otpMassage="Dear Customer,your OTP is +"+otp+" from the  SpringBoot Application"; 
		Message.creator(to,from,otpMassage).create();
		
	}
	private void sendWhatsAPPMassage(OtpDto dto, String userId) {
		Twilio.init(otpConfig.getAccountSid(), otpConfig.getAutnToken());
		PhoneNumber to=new PhoneNumber("whatsapp :"+dto.getMobileNumber());
		PhoneNumber from =new PhoneNumber("Whatsapp:+9755712095");
		String useridmessage="Dear Customer, your userId is+"+userId+" from the Spring Boot Application";
		Message.creator(to, from, useridmessage).create();
		
	}
	private void sendEmail(OtpDto otpDto, String otp, String email) {
		SimpleMailMessage message= new SimpleMailMessage();
		String emailSub="Otp sent From Olx";
		String textEmail="Hello, Your Otp is"+otp;
		message.setTo(email);
		message.setSubject(emailSub);
		message.setText(textEmail);
		emailSender.send(message);
		System.out.println("Email sent to:"+email);
	
	}
	public OtpDto ConvertToEntity(OtpUser otpUser) {
		OtpDto dto=new OtpDto();
		dto.setUserId(otpUser.getUserId());
		dto.setMobileNumber(otpUser.getMobileNumber());
		dto.setEmail(otpUser.getEmail());
		dto.setOtp(otpUser.getOtp());
		return dto;
		
	}
	public OtpDto ConvertToDto(OtpUser otpUser) {
		OtpDto dto=new OtpDto();
		dto.setUserId(otpUser.getUserId());
		dto.setMobileNumber(otpUser.getMobileNumber());
		dto.setEmail(otpUser.getEmail());
		dto.setOtp(otpUser.getOtp());
		return dto;
		}

}
