package com.ledza.cryptowhaleviewer.service;

import com.ledza.cryptowhaleviewer.utils.RequestUtil;
import org.springframework.stereotype.Service;

@Service
public class PriceService {

    public String getBitcoinHistoryPrice(){
        return RequestUtil.getBitcoinHistoryPrice();
    }

}
