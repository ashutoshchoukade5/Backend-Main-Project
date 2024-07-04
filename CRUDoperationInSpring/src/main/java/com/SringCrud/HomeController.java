package com.SringCrud;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.SpringCrud.Model.Employee;

@Controller
public class HomeController {
	
	    @RequestMapping("/")
	      public  String home() {
		
		    return"index";
	}
	@RequestMapping(path="/addRecord",method = RequestMethod.POST)
	public  String employeeData() {
		return "add" ;	
	}
	@RequestMapping(path="/create",method = RequestMethod.POST)
	public String createEmp(@ModelAttribute Employee emp) {
		System.out.println(emp);
		return "add";
	}

}
