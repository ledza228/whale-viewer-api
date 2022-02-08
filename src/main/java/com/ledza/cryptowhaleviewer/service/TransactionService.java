package com.ledza.cryptowhaleviewer.service;

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

    private List<String> stableCoins = List.of("BUSD", "GUSD", "HUSD", "USDC", "USDT", "BUSD");

    private String unknown = "Unknown";

    public List<Transaction> TransactionForEveryExchanges(String exchange, int days, boolean onlyStable, boolean onlyCrypto){
        LocalDateTime periodTime = LocalDateTime.now().minusDays(days);

        if (onlyStable && !onlyCrypto)
            return transactionRepository.findAllOnlyStableByDateAndExchange(periodTime, exchange, stableCoins);

        else if (onlyCrypto && !onlyStable)
            return transactionRepository.findAllOnlyNotStableByDateAndExchange(periodTime, exchange, stableCoins);

        else
            return transactionRepository.findAllByDateAfterAndRouteFromPlaceOrRouteToPlaceAndDateAfter(periodTime, exchange,exchange, periodTime);
    }

    public List<Transaction> getTransactionForAllExchanges(int days, boolean onlyStable, boolean onlyCrypto){
        LocalDateTime periodTime = LocalDateTime.now().minusDays(days);

        if (onlyStable && !onlyCrypto)
            return null;

        else if (onlyCrypto && !onlyStable)
            return null;

        else return transactionRepository.findForAllExchanges(periodTime,unknown);
    }


    public List<Transaction> getAllTransactions(){
        return transactionRepository.findAll();
    }


}
