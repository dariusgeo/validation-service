package ro.orange.service1.service;

import ro.orange.service1.model.EInteractionType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class InteractionTypeService {

    @Transactional(readOnly = true)
    public List<EInteractionType> readAll(){

        return Arrays.asList(EInteractionType.values());
    }
}
