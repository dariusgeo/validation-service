package edu.geodani.validation.controller;

import edu.geodani.validation.model.EInteractionType;
import edu.geodani.validation.service.InteractionTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/interaction-types")
@RequiredArgsConstructor
public class InteractionTypeController {

    private final InteractionTypeService interactionTypeService;

    @GetMapping(path = "/all")
    public ResponseEntity<List<EInteractionType>> getAllInteractionTypes(){

       return new ResponseEntity<>(interactionTypeService.readAll(), HttpStatus.OK);
    }
}
