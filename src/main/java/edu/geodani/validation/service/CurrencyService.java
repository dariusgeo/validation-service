package edu.geodani.validation.service;

import edu.geodani.validation.model.ECurrency;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class CurrencyService {

    @Transactional(readOnly = true)
    public List<ECurrency> readAll(){

       return Arrays.asList(ECurrency.values());
    }
}
