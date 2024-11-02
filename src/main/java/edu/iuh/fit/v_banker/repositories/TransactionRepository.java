package edu.iuh.fit.v_banker.repositories;

import edu.iuh.fit.v_banker.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, String> {
}
