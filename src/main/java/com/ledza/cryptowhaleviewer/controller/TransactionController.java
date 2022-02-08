package com.ledza.cryptowhaleviewer.controller;

import com.ledza.cryptowhaleviewer.dto.SingleRouteDTO;
import com.ledza.cryptowhaleviewer.entity.Coin;
import com.ledza.cryptowhaleviewer.entity.OperationType;
import com.ledza.cryptowhaleviewer.entity.Transaction;
import com.ledza.cryptowhaleviewer.entity.TransactionRoute;
import com.ledza.cryptowhaleviewer.service.CoinService;
import com.ledza.cryptowhaleviewer.service.OperationTypeService;
import com.ledza.cryptowhaleviewer.service.TransactionRouteService;
import com.ledza.cryptowhaleviewer.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @Autowired
    CoinService coinService;

    @Autowired
    OperationTypeService operationTypeService;

    @Autowired
    TransactionRouteService transactionRouteService;

    @GetMapping("/")
    public List<Transaction> getAll(){
        return transactionService.getAllTransactions();
    }

    @GetMapping("/coins")
    public List<Coin> getAllCoinTypes(){
        return coinService.getAllCoinTypes();
    }

    @GetMapping("/operations")
    public List<OperationType> getAllOperationTypes(){
        return operationTypeService.getAllOperationTypes();
    }

    @GetMapping("/routes/single")
    public Set<SingleRouteDTO> getAllRouteTypes(){
        return transactionRouteService.getAllSingleRouteTypes();
    }

    @GetMapping("/routes/pair")
    public List<TransactionRoute> getAllDualRouteTypes(){
        return transactionRouteService.getAllDualRouteTypes();
    }

    @GetMapping("transaction/")
    public List<Transaction> getTransactionByDateAndExchange(@RequestParam String exchange, @RequestParam int daysAgo, @RequestParam boolean onlyStable){
        return transactionService.getTransactionByDaysAndExchange(exchange, daysAgo, onlyStable);
    }

}
