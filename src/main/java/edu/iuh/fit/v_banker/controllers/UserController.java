package edu.iuh.fit.v_banker.controllers;

import edu.iuh.fit.v_banker.dto.BankResponse;
import edu.iuh.fit.v_banker.dto.CreditDebitRequest;
import edu.iuh.fit.v_banker.dto.EnquiryRequest;
import edu.iuh.fit.v_banker.dto.UserRequest;
import edu.iuh.fit.v_banker.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public BankResponse createAccount(@RequestBody UserRequest userRequest) {
        return userService.createAccount(userRequest);
    }

    @GetMapping("/balanceEnquiry")
    public BankResponse balanceEnquiry(@RequestBody EnquiryRequest request){
        return userService.balanceEnquiry(request);
    }

    @GetMapping("/nameEnquiry")
    public String nameEnquiry(@RequestBody EnquiryRequest request){
        return userService.nameEnquiry(request);
    }

    @PostMapping("/credit")
    public BankResponse creditAccount(@RequestBody CreditDebitRequest request){
        return userService.creditAccount(request);
    }
}
