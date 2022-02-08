package com.ledza.cryptowhaleviewer.service;

import com.ledza.cryptowhaleviewer.entity.Coin;
import com.ledza.cryptowhaleviewer.repository.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoinService {

    @Autowired
    CoinRepository coinRepository;

    public List<Coin> getAllCoinTypes(){
        return coinRepository.findAll();
    }

}
