package edu.iuh.fit.v_banker.repositories;

import edu.iuh.fit.v_banker.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, String> {
    List<Transaction> findTransactionsByTransactionDateBetween(LocalDateTime startDate, LocalDateTime endDate);
}
