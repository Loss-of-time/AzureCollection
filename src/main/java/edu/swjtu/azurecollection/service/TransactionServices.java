package edu.swjtu.azurecollection.service;

import edu.swjtu.azurecollection.pojo.Transaction;
import edu.swjtu.azurecollection.pojo.dto.TransactionDto;
import edu.swjtu.azurecollection.repository.TransactionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServices implements ITransactionServices{

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public  Transaction add(TransactionDto transaction) {
        Transaction transactionPojo = new Transaction();
        BeanUtils.copyProperties(transaction, transactionPojo);

        System.out.println("Received transaction date: " + transaction.getTransactionDate());
        return transactionRepository.save(transactionPojo);
    }
    @Override
    public Transaction get(Long collectionId){
        return  transactionRepository.findById(collectionId).orElseThrow(()->{
             throw new IllegalArgumentException ("error");
         });
    }

    @Override
    public Transaction edit(TransactionDto transaction) {
        Transaction transactionPojo = new Transaction();
        BeanUtils.copyProperties(transaction, transactionPojo);

        return transactionRepository.save(transactionPojo);
    }

    @Override
    public Iterable<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }
}
