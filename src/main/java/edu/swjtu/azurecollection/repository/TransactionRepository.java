package edu.swjtu.azurecollection.repository;

import edu.swjtu.azurecollection.pojo.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface  TransactionRepository extends CrudRepository<Transaction, Long> {

}