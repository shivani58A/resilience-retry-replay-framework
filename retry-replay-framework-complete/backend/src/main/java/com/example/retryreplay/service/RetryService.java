package com.example.retryreplay.service;

import com.example.retryreplay.model.Transaction;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RetryService {
    private Map<String, Transaction> transactions = new HashMap<>();

    public RetryService() {
        transactions.put("txn001", new Transaction("txn001", "FAILED", "TYPE1", "{...}"));
        transactions.put("txn002", new Transaction("txn002", "FAILED", "TYPE2", "{...}"));
    }

    public List<Transaction> getAll() {
        return new ArrayList<>(transactions.values());
    }

    public String retry(String id) {
        Transaction txn = transactions.get(id);
        if (txn != null && txn.getStatus().equals("FAILED")) {
            txn.setStatus("RETRIED");
            return "Transaction " + id + " retried successfully!";
        }
        return "Transaction not found or already successful.";
    }
}