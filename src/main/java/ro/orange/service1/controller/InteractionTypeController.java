package ro.orange.service1.controller;

import ro.orange.service1.model.EInteractionType;
import ro.orange.service1.service.InteractionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/interaction-types")
public class InteractionTypeController {

    @Autowired
    private InteractionTypeService interactionTypeService;

    @GetMapping(path = "/all")
    public ResponseEntity<List<EInteractionType>> getAllInteractionTypes(){

       return new ResponseEntity<>(interactionTypeService.readAll(), HttpStatus.OK);
    }
}
