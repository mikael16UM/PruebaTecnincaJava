package com.miguel.miguel.validation;

import com.miguel.miguel.exception.NotValidFieldException;

import java.util.List;

public class OperatorValidation {

    private static final List<String> ALLOWED_OPERATORS = List.of(
            "eq", //equals
            "co", //equals
            "sw", //stars with
            "ew" //ends with
    );

    public static void OperatorValidation (String operator) {
        if (operator == null || operator.isBlank())
            return;
        if (!ALLOWED_OPERATORS.contains(operator))
            throw new NotValidFieldException(operator + " is not a valid operator");

    }
}
