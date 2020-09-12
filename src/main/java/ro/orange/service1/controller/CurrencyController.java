package ro.orange.service1.controller;

import ro.orange.service1.model.ECurrency;
import ro.orange.service1.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/currencies")
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @GetMapping(path = "/all")
    public ResponseEntity<List<ECurrency>> getAllCurrencies(){

       return new ResponseEntity<>(currencyService.readAll(), HttpStatus.OK);
    }

}
