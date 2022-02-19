package com.ledza.cryptowhaleviewer.controller;

import com.ledza.cryptowhaleviewer.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
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

    @CacheEvict(cacheNames = {"price"},allEntries = true)
    @Scheduled(fixedDelay = 60*60*2*1000)
    public void cacheEvict() {
    }

}
