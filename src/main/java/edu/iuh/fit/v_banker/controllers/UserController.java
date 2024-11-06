package edu.iuh.fit.v_banker.controllers;

import edu.iuh.fit.v_banker.dto.*;
import edu.iuh.fit.v_banker.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@Tag(name = "User Account Management APIs")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public BankResponse<AccountInfo>  login(@RequestBody LoginDto loginDto){
        return userService.login(loginDto);
    }

    @PostMapping
    public BankResponse<AccountInfo> createAccount(@RequestBody UserRequest userRequest) {
        return userService.createAccount(userRequest);
    }


    @GetMapping( "/balanceEnquiry")
    public BankResponse<AccountInfo> balanceEnquiry(@RequestParam String accountNumber){
        EnquiryRequest request = new EnquiryRequest();
        request.setAccountNumber(accountNumber);
        return userService.balanceEnquiry(request);
    }


    @GetMapping("/nameEnquiry")
    public String nameEnquiry(@RequestParam String accountNumber){
        EnquiryRequest request = new EnquiryRequest();
        request.setAccountNumber(accountNumber);
        return userService.nameEnquiry(request);
    }


    @PostMapping("/credit")
    public BankResponse<AccountInfo> creditAccount(@RequestBody CreditDebitRequest request){
        return userService.creditAccount(request);
    }


    @PostMapping("/debit")
    public BankResponse<AccountInfo> debitAccount(@RequestBody CreditDebitRequest request){
        return userService.debitAccount(request);
    }


    @PostMapping("/transfer")
    public BankResponse<AccountInfo> transfer(@RequestBody TransferRequest request){
        return userService.transfer(request);
    }
}
