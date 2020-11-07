package edu.geodani.validation.service;

import edu.geodani.validation.model.ETransactionType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class TransactionTypeService {

    @Transactional(readOnly = true)
    public List<ETransactionType> readAll(){

       return Arrays.asList(ETransactionType.values());
    }
}
