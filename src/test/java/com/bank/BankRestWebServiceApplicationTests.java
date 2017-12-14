package com.bank;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.domain.UserInfo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BankRestWebServiceApplicationTests {

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void registerUser(){	 
		RestTemplate restTemplate=new RestTemplate();
		UserInfo userInfo=new UserInfo();
		userInfo.setUserName("Sandeep");
		userInfo.setPassword("Sandeep123");
		userInfo.setRetypePassword("Sandeep123");
		userInfo.setAccountType("Saving");
		userInfo.setAddressLine1("AddressLine1");
		userInfo.setAddressLine2("AddressLine2");
		userInfo.setBranchName("Pune");
		userInfo.setCitizenship("Indian");
		userInfo.setCity("Pune");
		userInfo.setContactNumber("9823365571");
		userInfo.setCountry("India");
		userInfo.setDob("1984-03-15");
		userInfo.setEmail("Sandeep.p@gmail.com");
		userInfo.setGender("Male");
		userInfo.setInitDepositAmount("1000.10");
		userInfo.setPanNumber("AOVPP");
		userInfo.setPin("2121");
		userInfo.setRegistrationDate("2017-11-12");
		userInfo.setState("MAHARASHTRA");
		String message=restTemplate.postForObject("http://localhost:8080/register", userInfo, String.class);
		System.out.println( ""+message);
	}

}
