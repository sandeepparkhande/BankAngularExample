package com.data;

import org.springframework.data.repository.CrudRepository;
import com.domain.Transaction;
public interface TransactionRepository extends CrudRepository<Transaction, Long> {

}
