package com.railworld.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.railworld.Dto.OtpDto;
import com.railworld.service.OTPService;

@RestController
public class OTPController {

	@Autowired
	private OTPService OtpService;
	
	
	@PostMapping("/generateOTP")
	
	public ResponseEntity<OtpDto>generateOtp(@RequestBody OtpDto response){
		OtpDto  responseDto=OtpService.generateOtp(response);
		return ResponseEntity.ok(responseDto);
		
	}
	
	@PostMapping("/validateOTP")
	public ResponseEntity<OtpDto>validateOTP(@RequestBody OtpDto response){
		OtpDto responseDTO=OtpService.validateOTP(response);
		if(responseDTO!=null&&responseDTO.getUserId()!=null) {
			return ResponseEntity.ok(responseDTO);
		}
		else {
			return ResponseEntity.badRequest().build();
		}
		
	}
	
	
}
