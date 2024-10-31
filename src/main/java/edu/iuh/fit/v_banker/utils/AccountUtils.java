package edu.iuh.fit.v_banker.utils;

import jakarta.servlet.http.PushBuilder;

import java.time.Year;

public class AccountUtils {

    public static final String ACCOUNT_EXISTS_CODE = "001";
    public static final String ACCOUNT_EXISTS_MESSAGE = "This user already has an account Created";
    public static final String ACCOUNT_CREATED_SUCCESS = "002";
    public static final String ACCOUNT_CREATED_SUCCESS_MESSAGE = "Account has been created Successfully";
    public static final String ACCOUNT_NOT_EXIST_CODE = "003";
    public static final String ACCOUNT_NOT_EXIST_MESSAGE = "User with the provided account number does not exist";
    public static final String ACCOUNT_FOUND_CODE = "004";
    public static final String ACCOUNT_FOUND_MESSAGE = "User Account found";
    public static final String ACCOUNT_CREDITED_SUCCESS = "005";
    public static final String ACCOUNT_CREDITED_SUCCESS_MESSAGE = "Account has been credited successfully";
    public static final String INSUFFICIENT_BALANCE_CODE = "006";
    public static final String INSUFFICIENT_BALANCE_MESSAGE = "Insufficient balance in the account";
    public static final String ACCOUNT_DEBITED_SUCCESS = "007";
    public static final String ACCOUNT_DEBITED_SUCCESS_MESSAGE = "Account has been debited successfully";
    public static final String TRANSFER_SUCCESS = "008";
    public static final String TRANSFER_SUCCESS_MESSAGE = "Transfer has been completed successfully";

    /**
     * 2024 + randomSixDigits
     */

    public static String generateAccountNumber() {
        Year currentYear = Year.now();
        int min = 100000;
        int max = 999999;

        //generate a random number between min and max
        int randNumber = (int) Math.floor(Math.random() *(max - min + 1) + min);

        //convert the current and random number to string, then concatenate them
        String year = String.valueOf(currentYear);
        String randomNumber = String.valueOf(randNumber);

        StringBuilder accountNumber = new StringBuilder();

        //return account number format: 2024 + randomSixDigits
        return accountNumber.append(year).append(randomNumber).toString();
    }
}
