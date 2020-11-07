package edu.geodani.validation.dto;

import edu.geodani.validation.validation.CNP;
import lombok.ToString;
import lombok.Data;

@Data
@ToString
public class CustomerDTO {

    private Long id;
    private String firstname;
    private String lastname;
    @CNP
    private String cnp;
}
