package com.bank.services;

import com.bank.entities.Operation;
import com.bank.repositories.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class OprerationServiceImpl implements OperationService{

    private OperationRepository operationRepository;
    @Autowired
    public void setOperationRepository(OperationRepository operationRepository) {
        this.operationRepository = operationRepository;
    }

    @Override
    public Iterable<Operation> listOperations(String codeAccount) {
        Iterable<Operation> operations = operationRepository.findAll( );
        return operations;
    }
}
