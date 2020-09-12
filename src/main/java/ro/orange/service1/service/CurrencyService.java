package ro.orange.service1.service;

import ro.orange.service1.model.ECurrency;
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
