package com.bank;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.data.BankDataRepository;
import com.data.TransactionRepository;
import com.domain.Statement;
import com.domain.Transaction;
import com.domain.User;
import com.domain.UserInfo;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class BankController {

	@Autowired
	BankDataRepository bankDataRepository;

	@Autowired
	TransactionRepository transactionRepository;

	@Autowired
	EntityManager entityManager;

	@PostMapping("/login")
	@CrossOrigin
	public String login(@RequestBody User user) {
		System.out.println(" Request " + user.toString());
		UserInfo userInfo=bankDataRepository.findByUserNameAndPassword(user.getUserName(), user.getPassword());
		if(userInfo!=null){
			System.out.println(" Login Successfully "+userInfo.toString());
			return "success";
		}
		return "Request Failed";
	}

	@PostMapping("/statement")
	@CrossOrigin
	public String statement(@RequestBody Statement statement) {
		System.out.println(" Request " + statement.toString());
		
		String query = "select t from Transaction t where t.transactionDate >= :from and  t.transactionDate <= :to  and t.accountType = :accountType";
		
		TypedQuery<Transaction> typedQuery = entityManager.createQuery(query, Transaction.class);
		typedQuery.setParameter("from",statement.getFrom());
		typedQuery.setParameter("to", statement.getTo());
		typedQuery.setParameter("accountType", statement.getTransactionType());
		//typedQuery.setParameter(4, statement.getTransactionNo());
		List<Transaction> transactions=typedQuery.getResultList();
		return transactions.toString();
	}

	@PostMapping("/transaction")
	@CrossOrigin
	public String transaction(@RequestBody Transaction transaction) {
		System.out.println(" Request " + transaction.toString());
		Transaction transactionObj=transactionRepository.save(transaction);
		if(transactionObj!=null){
			System.out.println("Transaction Successfully" + transactionRepository.findAll().toString());
			return "success";
		}
		return "Transaction Failed" ;
	}

	@PostMapping("/register")
	@CrossOrigin
	public String register(@RequestBody UserInfo userInfo) {
		System.out.println(" Request " + userInfo.toString());
		
		UserInfo userInfoExits=bankDataRepository.findByPanNumber(userInfo.getPanNumber());
		if(userInfoExits==null){
		bankDataRepository.save(userInfo);
		System.out.println(" User Successfully saved"+bankDataRepository.findAll().toString());
		return "success";
		}
		
		return "Register Failed " ;
	}

	private UserInfo initUser() {
		UserInfo userInfo = new UserInfo();
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
	
		return userInfo;
	}
	
	public void jsonObjectMapper(Object obj){
		com.fasterxml.jackson.databind.ObjectMapper mapper=new com.fasterxml.jackson.databind.ObjectMapper();
		String json;
		try {
			json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
			System.out.println(" Json "+json);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		BankController controller=new BankController();
		controller.jsonObjectMapper(new UserInfo());
		controller.jsonObjectMapper(new User());
		controller.jsonObjectMapper(new Transaction());
		controller.jsonObjectMapper(new Statement());
		
	}

}
