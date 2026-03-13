package com.miguel.miguel.validation;

import com.miguel.miguel.exception.NotValidFieldException;

import java.util.List;

public class FieldValidation {
    private static final List<String> ALLOWED_FIELDS = List.of(
            "email",
            "id",
            "name",
            "phone",
            "taxId",
            "createdAt"
    );

    public static void FieldValidation (String field) {
        if (field == null || field.isBlank())
            return;
        if (!ALLOWED_FIELDS.contains(field))
            throw new NotValidFieldException(field + " is not a valid field");

    }
}
