package edu.geodani.validation.dto;

import edu.geodani.validation.validation.CNP;
import lombok.Data;
import lombok.ToString;
import org.apache.bval.extras.constraints.checkdigit.IBAN;

import java.util.List;

@Data
@ToString
public class ReportDTO {

    private Long id;
    @CNP
    private String cnp;
    @IBAN
    private String iban;

    private CustomerDTO customer;

    private List<TransactionDTO> transactions;
}
