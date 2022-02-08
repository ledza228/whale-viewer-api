package com.ledza.cryptowhaleviewer.service;

import com.ledza.cryptowhaleviewer.dto.SingleRouteDTO;
import com.ledza.cryptowhaleviewer.entity.Transaction;
import com.ledza.cryptowhaleviewer.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    public List<Transaction> getAllTransactions(){
        return transactionRepository.findAll();
    }

    public List<Transaction> getTransactionByDaysAndExchange(String exchange, int days, boolean onlyStable){
        LocalDateTime periodTime = LocalDateTime.now().minusDays(days);
        if (!onlyStable)
            return transactionRepository.findAllByDateAfterAndRouteFromPlaceOrRouteToPlaceAndDateAfter(periodTime, exchange,exchange, periodTime);
        else{
            List<String> stables = List.of("BUSD", "GUSD", "HUSD", "USDC", "USDT", "BUSD");
            return transactionRepository.findAllWithStableCoins(periodTime, exchange, stables);
        }

    }

}
