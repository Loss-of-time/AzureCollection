package edu.swjtu.azurecollection.service;

import edu.swjtu.azurecollection.pojo.DigitalCollectible;
import edu.swjtu.azurecollection.pojo.Transaction;
import edu.swjtu.azurecollection.pojo.User;
import edu.swjtu.azurecollection.pojo.dto.DigitalCollectibleDto;
import edu.swjtu.azurecollection.pojo.dto.TransactionDto;
import edu.swjtu.azurecollection.pojo.dto.UserLoginDto;
import edu.swjtu.azurecollection.repository.DigitalCollectibleRepository;
import edu.swjtu.azurecollection.repository.TransactionRepository;
import edu.swjtu.azurecollection.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TransactionServices implements ITransactionServices{

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public  Transaction add(TransactionDto transaction) {
        Transaction transactionPojo = new Transaction();
        BeanUtils.copyProperties(transaction, transactionPojo);

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
}
