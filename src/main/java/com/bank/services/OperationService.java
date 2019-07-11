package com.bank.services;

import com.bank.entities.Operation;

public interface OperationService {
    public Iterable<Operation> listOperations(String codeAccount);
}
