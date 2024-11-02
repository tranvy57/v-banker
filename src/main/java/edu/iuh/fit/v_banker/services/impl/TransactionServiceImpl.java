package edu.iuh.fit.v_banker.services.impl;

import edu.iuh.fit.v_banker.dto.TransactionDto;
import edu.iuh.fit.v_banker.entities.Transaction;
import edu.iuh.fit.v_banker.repositories.TransactionRepository;
import edu.iuh.fit.v_banker.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public void saveTransaction(TransactionDto transactionDto) {
        Transaction transaction = Transaction.builder()
                .transactionType(transactionDto.getTransactionType())
                .accountNumber(transactionDto.getAccountNumber())
                .amount(transactionDto.getAmount())
                .status("SUCCESS")
                .transactionDate(java.time.LocalDateTime.now())
                .build();

        transactionRepository.save(transaction);
        System.out.println("Transaction saved successfully");
    }
}
