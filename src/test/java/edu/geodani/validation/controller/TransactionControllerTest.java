package edu.geodani.validation.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.geodani.validation.ValidationServiceApplication;
import edu.geodani.validation.dto.CustomerDTO;
import edu.geodani.validation.dto.TransactionDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { ValidationServiceApplication.class })
@WebMvcTest(TransactionController.class)
public class TransactionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testNullPayerIBAN() throws Exception {
        TransactionDTO transaction = createDummyTransaction();
        transaction.setPayerIBAN(null);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/api/transactions")
                .with(csrf())
                .content(objectMapper.writeValueAsString(transaction))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String result2 = result.getResponse().getContentAsString();
        assertNotNull(result2);
    }

    private TransactionDTO createDummyTransaction() {
        TransactionDTO transaction = new TransactionDTO();
        CustomerDTO payer = new CustomerDTO();
        payer.setFirstname("John");
        payer.setLastname("Doe");
        payer.setCnp("1810430132811");
        CustomerDTO payee = new CustomerDTO();
        payee.setFirstname("Michael");
        payee.setLastname("Smith");
        payee.setCnp("2821129132802");
        transaction.setPayer(payer);
        transaction.setPayee(payee);
        transaction.setAmount(550.00);
        transaction.setCurrencyId(1);
        transaction.setTransactionTypeId(1);
        transaction.setPayerIBAN("RO38INGB0000999903101608");
        transaction.setPayeeIBAN("RO41INGB0000999908325683");

        return transaction;
    }
}
