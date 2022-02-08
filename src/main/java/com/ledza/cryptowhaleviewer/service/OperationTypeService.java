package com.ledza.cryptowhaleviewer.service;

import com.ledza.cryptowhaleviewer.entity.OperationType;
import com.ledza.cryptowhaleviewer.repository.OperationTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperationTypeService {

    @Autowired
    OperationTypeRepository operationTypeRepository;

    public List<OperationType> getAllOperationTypes(){
        return operationTypeRepository.findAll();
    }

}
