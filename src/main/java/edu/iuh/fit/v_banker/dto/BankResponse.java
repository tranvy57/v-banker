package edu.iuh.fit.v_banker.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BankResponse <T> {
    private String responseCode;
    private String responseMessage;
    private T result;
}
