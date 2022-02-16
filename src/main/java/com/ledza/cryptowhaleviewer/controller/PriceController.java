package com.ledza.cryptowhaleviewer.controller;

import com.ledza.cryptowhaleviewer.service.PriceService;
import com.ledza.cryptowhaleviewer.utils.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin("*")
public class PriceController {

    @Autowired
    PriceService priceService;

    @GetMapping("/price/history/bitcoin")
    @Cacheable("price")
    public String getBitcoinHistoryAPI(){
        return  priceService.getBitcoinHistoryPrice();
    }

}
