package edu.geodani.validation.controller;

import edu.geodani.validation.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import edu.geodani.validation.dto.ReportDTO;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/report")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

    @PutMapping
    public ResponseEntity<ReportDTO> createTransaction(@RequestBody @Valid ReportDTO reportDTO){
        return new ResponseEntity<>(reportService.generateReport(reportDTO), HttpStatus.OK);
    }
}
