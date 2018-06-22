package com.bank.controller;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bank.model.BankLoginDetails;
import com.bank.model.BankLoginUserDetails;
import com.bank.model.BankUserDetails;
import com.bank.service.BankingService;

@Controller
public class BankingSystemController {

	private static final Logger logger = Logger
			.getLogger(BankingSystemController.class);

	public BankingSystemController() {
		System.out.println("BankingSystemController()");
	}

	@Autowired
	private BankingService bankingService;
	
	@RequestMapping("/")
	public String showHomePage() {
		return "home";
	}

	@RequestMapping(value = "/newUser", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model) {
		BankUserDetails bankUserDetails = new BankUserDetails();
		model.addObject("bankUserDetails", bankUserDetails);
		model.setViewName("UserApplicationForm");
		return model;
	}

	@RequestMapping(value = "/saveUserDetails", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute BankUserDetails bankUserDetails) {
	bankingService.addNewUser(bankUserDetails);
	return new ModelAndView("redirect:/");
	}

	
	@RequestMapping(value = "/validateUser", method = RequestMethod.POST)
	public ModelAndView validateUser(BankLoginUserDetails bankLoginUserDetails ) {
		ModelAndView modelAndView=new ModelAndView();
		String emailId = bankLoginUserDetails.getUsername();
		String passWord = bankLoginUserDetails.getUsername();
		BankUserDetails bankUserDetails = bankingService.validateUser(emailId);
		if(bankUserDetails!=null){
			if(StringUtils.pathEquals(passWord,bankUserDetails.getPassword()));{
				modelAndView.setViewName("loginSuccessPage");
				return  modelAndView;
			}
		}
		modelAndView.setViewName("Error");
		return  modelAndView;
	}
	
	
	@RequestMapping(value = "/bankUserValidation", method = RequestMethod.POST)
	public ModelAndView validateBankUser(BankLoginDetails bankLoginDetails) {
		ModelAndView modelAndView = new ModelAndView();
		String bankName = bankLoginDetails.getBankName();
		String customerID = bankLoginDetails.getCustomerID();
		StringBuffer buffer=new StringBuffer();
		BankUserDetails bankUserDetails = bankingService.validateBankUser(customerID);
		if (bankUserDetails != null) {
			if (StringUtils.pathEquals(bankUserDetails.getBankName(), bankName)){
				buffer.append(bankName).append("BankPage");
				modelAndView.setViewName(buffer.toString());
				return modelAndView;
			}else{
				modelAndView.setViewName("BankLoginError");
				return modelAndView;
			}
		}
		modelAndView.setViewName("Error");
		return modelAndView;

	}
}