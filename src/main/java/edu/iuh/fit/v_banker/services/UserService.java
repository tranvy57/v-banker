package edu.iuh.fit.v_banker.services;

import edu.iuh.fit.v_banker.dto.BankResponse;
import edu.iuh.fit.v_banker.dto.CreditDebitRequest;
import edu.iuh.fit.v_banker.dto.EnquiryRequest;
import edu.iuh.fit.v_banker.dto.UserRequest;

public interface UserService {
    BankResponse createAccount(UserRequest userRequest);
    BankResponse balanceEnquiry(EnquiryRequest request);
    String nameEnquiry(EnquiryRequest request);
    BankResponse creditAccount(CreditDebitRequest request);
}
