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
    @Operation(
            summary = "Create a new account",
            description = "Create a new account and assigning an account ID"
    )

    @PostMapping("/login")
    public BankResponse login(@RequestBody LoginDto loginDto){
        return userService.login(loginDto);
    }

    @PostMapping
    public BankResponse createAccount(@RequestBody UserRequest userRequest) {
        return userService.createAccount(userRequest);
    }



    @Operation(
            summary = "Balance Enquiry",
            description = "Given an account number, check how much the user has"
    )
    @GetMapping( "/balanceEnquiry")
    public BankResponse balanceEnquiry(@RequestParam String accountNumber){
        EnquiryRequest request = new EnquiryRequest();
        request.setAccountNumber(accountNumber);
        return userService.balanceEnquiry(request);
    }

    @Operation(
            summary = "Name Enquiry",
            description = "Given an account number, check the name of the account holder"
    )
    @GetMapping("/nameEnquiry")
    public String nameEnquiry(@RequestParam String accountNumber){
        EnquiryRequest request = new EnquiryRequest();
        request.setAccountNumber(accountNumber);
        return userService.nameEnquiry(request);
    }

    @Operation(
            summary = "Credit Account",
            description = "Given an account number, credit the account with the amount"
    )
    @PostMapping("/credit")
    public BankResponse creditAccount(@RequestBody CreditDebitRequest request){
        return userService.creditAccount(request);
    }

    @Operation(
            summary = "Debit Account",
            description = "Given an account number, debit the account with the amount"
    )
    @PostMapping("/debit")
    public BankResponse debitAccount(@RequestBody CreditDebitRequest request){
        return userService.debitAccount(request);
    }

    @Operation(
            summary = "Transfer",
            description = "Given an account number, transfer the amount to another account"
    )
    @PostMapping("/transfer")
    public BankResponse transfer(@RequestBody TransferRequest request){
        return userService.transfer(request);
    }
}
