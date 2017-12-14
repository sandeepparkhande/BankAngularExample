package com.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.domain.UserInfo;

@Repository
public interface BankDataRepository extends CrudRepository<UserInfo, Long>{
	public UserInfo findByUserNameAndPassword(String userName,String password);
	public UserInfo findByPanNumber(String panNumber);
}
