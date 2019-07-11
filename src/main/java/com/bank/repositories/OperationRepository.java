package com.bank.repositories;

import com.bank.entities.Operation;
import org.springframework.data.repository.CrudRepository;

public interface OperationRepository extends CrudRepository<Operation, String> {
}
