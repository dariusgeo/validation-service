package edu.geodani.validation.controller;

import edu.geodani.validation.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import edu.geodani.validation.model.ECurrency;

import java.util.List;

@RestController
@RequestMapping(value = "/api/currencies")
@RequiredArgsConstructor
public class CurrencyController {

    private final CurrencyService currencyService;

    @GetMapping(path = "/all")
    public ResponseEntity<List<ECurrency>> getAllCurrencies(){

       return new ResponseEntity<>(currencyService.readAll(), HttpStatus.OK);
    }

}
