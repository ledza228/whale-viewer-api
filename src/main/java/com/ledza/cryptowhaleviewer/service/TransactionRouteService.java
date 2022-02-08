package com.ledza.cryptowhaleviewer.service;

import com.ledza.cryptowhaleviewer.dto.SingleRouteDTO;
import com.ledza.cryptowhaleviewer.entity.TransactionRoute;
import com.ledza.cryptowhaleviewer.repository.TransactionRouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TransactionRouteService {

    @Autowired
    private TransactionRouteRepository transactionRouteRepository;

    public Set<SingleRouteDTO> getAllSingleRouteTypes(){
        Set<SingleRouteDTO> routeTypes = new HashSet<>();
        List<TransactionRoute> routeDualTypes =  transactionRouteRepository.findAll();

        routeDualTypes.forEach((i)->{routeTypes.add(new SingleRouteDTO(i.getFromPlace()));
                                routeTypes.add(new SingleRouteDTO(i.getToPlace()));});
        return routeTypes;
    }

    public List<TransactionRoute> getAllDualRouteTypes(){
        return transactionRouteRepository.findAll();
    }

}
