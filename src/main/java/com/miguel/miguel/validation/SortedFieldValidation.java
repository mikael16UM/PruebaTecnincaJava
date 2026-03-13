package com.miguel.miguel.validation;

import com.miguel.miguel.exception.NotValidFieldException;

import java.util.List;

public class SortedFieldValidation {
    private static final List<String> ALLOWED_FIELDS = List.of(
            "email",
            "id",
            "name",
            "phone",
            "taxId",
            "createdAt"
    );

    public static void FieldValidation (String sorted_by) {
        if (sorted_by == null || sorted_by.isBlank())
            return;
        if (!ALLOWED_FIELDS.contains(sorted_by))
            throw new NotValidFieldException(sorted_by + " is not a valid field");

    }
}
