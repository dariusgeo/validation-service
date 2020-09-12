package ro.orange.service1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.orange.service1.dto.TransactionDTO;
import ro.orange.service1.service.TransactionService;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PutMapping
    public ResponseEntity<Void> createTransaction(@RequestBody @Valid TransactionDTO transactionDTO){
        transactionService.createTransaction(transactionDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
