package edu.iuh.fit.v_banker.services;

import edu.iuh.fit.v_banker.dto.BankResponse;
import edu.iuh.fit.v_banker.dto.UserRequest;

public interface UserService {
    BankResponse createAccount(UserRequest userRequest);
}
