package com.example.retryreplay.controller;

import com.example.retryreplay.model.Transaction;
import com.example.retryreplay.service.RetryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RetryController {

    @Autowired
    private RetryService retryService;

    @GetMapping("/transactions")
    public List<Transaction> getAll() {
        return retryService.getAll();
    }

    @PostMapping("/retry/{id}")
    public String retry(@PathVariable String id) {
        return retryService.retry(id);
    }
}