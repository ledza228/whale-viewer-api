package com.ledza.cryptowhaleviewer.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class RequestUtil {

    private static RestTemplate restTemplate;

    private static String bitcoinUrl;

    private static String persistedQuery;

    private static String variables;

    public static String getBitcoinHistoryPrice(){
        System.out.println("REQUEST TO ANOTHER API");
        return restTemplate.getForObject(bitcoinUrl, String.class, persistedQuery, variables);
    }

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        RequestUtil.restTemplate = restTemplate;
    }

    @Value("${url.history.bitcoin}")
    public void setBitcoinUrl(String bitcoinUrl) {
        RequestUtil.bitcoinUrl = bitcoinUrl;
    }

    @Value("${url.part.query}")
    public void setPersistedQuery(String persistedQuery) {
        RequestUtil.persistedQuery = persistedQuery;
    }

    @Value("${url.part.variables}")
    public void setVariables(String variables) {
        RequestUtil.variables = variables;
    }
}
