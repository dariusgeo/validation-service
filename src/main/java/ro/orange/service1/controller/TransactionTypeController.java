package ro.orange.service1.controller;

import ro.orange.service1.model.ETransactionType;
import ro.orange.service1.service.TransactionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/transaction-types")
public class TransactionTypeController {

    @Autowired
    private TransactionTypeService transactionTypeService;

    @GetMapping(path = "/all")
    public ResponseEntity<List<ETransactionType>> getAllTransactionTypes(){

      return new ResponseEntity<>(transactionTypeService.readAll(), HttpStatus.OK);
    }

}
