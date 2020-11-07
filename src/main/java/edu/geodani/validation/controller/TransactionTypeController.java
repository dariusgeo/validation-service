package edu.geodani.validation.controller;

import edu.geodani.validation.model.ETransactionType;
import edu.geodani.validation.service.TransactionTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/transaction-types")
@RequiredArgsConstructor
public class TransactionTypeController {

    private final TransactionTypeService transactionTypeService;

    @GetMapping(path = "/all")
    public ResponseEntity<List<ETransactionType>> getAllTransactionTypes(){

      return new ResponseEntity<>(transactionTypeService.readAll(), HttpStatus.OK);
    }

}
