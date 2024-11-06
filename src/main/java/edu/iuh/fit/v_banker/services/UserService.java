package edu.iuh.fit.v_banker.services;

import edu.iuh.fit.v_banker.dto.*;
import edu.iuh.fit.v_banker.entities.User;

import java.util.List;

public interface UserService {
    BankResponse<AccountInfo> createAccount(UserRequest userRequest);
    BankResponse<AccountInfo> balanceEnquiry(EnquiryRequest request);
    String nameEnquiry(EnquiryRequest request);
    BankResponse<AccountInfo> creditAccount(CreditDebitRequest request);
    BankResponse<AccountInfo> debitAccount(CreditDebitRequest request);
    BankResponse<AccountInfo> transfer(TransferRequest request);
    BankResponse<AccountInfo> login(LoginDto loginDto);
    BankResponse<List<User>> getAllAccounts();
}
