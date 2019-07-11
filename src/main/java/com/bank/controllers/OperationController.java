package com.bank.controllers;

import com.bank.entities.Operation;
import com.bank.services.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class OperationController {

    private OperationService operationService;
    @Autowired
    public void setOperationService(OperationService operationService) {
        this.operationService = operationService;
    }

    /**
     * afficher Operations.
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/listOperation", method = RequestMethod.GET)
    public String getListOperations(Model model, String accountCode) {
        model.addAttribute("accountCode", accountCode);
        try {
            Iterable<Operation> operations = operationService.listOperations(accountCode);
            model.addAttribute("operations", operations);
        } catch(Exception e) {
            model.addAttribute("exception", e);
        }
        return "operations";
    }
}
