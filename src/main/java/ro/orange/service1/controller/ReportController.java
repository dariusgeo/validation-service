package ro.orange.service1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.orange.service1.dto.ReportDTO;
import ro.orange.service1.service.ReportService;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @PutMapping
    public ResponseEntity<ReportDTO> createTransaction(@RequestBody @Valid ReportDTO reportDTO){
        reportDTO = reportService.generateReport(reportDTO);
        return new ResponseEntity<>(reportDTO, HttpStatus.OK);
    }
}
