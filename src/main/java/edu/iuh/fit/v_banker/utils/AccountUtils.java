package edu.iuh.fit.v_banker.utils;

import java.time.Year;

public class AccountUtils {

    public static final String ACCOUNT_EXISTS_CODE = "001";
    public static final String ACCOUNT_EXISTS_MESSAGE = "This user already has an account Created";
    public static final String ACCOUNT_CREATED_SUCCESS = "002";
    public static final String ACCOUNT_CREATED_SUCCESS_MESSAGE = "Account has been created Successfully";

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
        return accountNumber.append(year).append(randomNumber).toString();
    }
}
