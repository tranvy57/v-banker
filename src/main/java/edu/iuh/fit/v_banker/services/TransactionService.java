package edu.iuh.fit.v_banker.services;

import edu.iuh.fit.v_banker.dto.TransactionDto;
import jakarta.transaction.Transaction;

public interface TransactionService {
    void saveTransaction(TransactionDto transactionDto);
}
