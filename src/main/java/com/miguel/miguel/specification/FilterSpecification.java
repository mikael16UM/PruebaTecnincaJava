package com.miguel.miguel.specification;

import com.miguel.miguel.exception.NotValidOperatorException;
import com.miguel.miguel.model.User;
import org.springframework.data.jpa.domain.Specification;

import java.util.UUID;

public class FilterSpecification {

    public static Specification<User> filterBy(String field, String operator, String value) {

        return (root, query, criteriaBuilder) -> {

            switch (operator) {

                case "eq":

                    if(field.equals("id")){
                        UUID uuid = UUID.fromString(value);
                        return criteriaBuilder.equal(root.get(field), uuid);
                    }
                    return criteriaBuilder.equal(root.get(field), value);

                case "co":
                    return criteriaBuilder.like(
                            criteriaBuilder.lower(root.get(field)),
                            "%" + value.toLowerCase() + "%"
                    );

                case "sw":
                    return criteriaBuilder.like(
                            criteriaBuilder.lower(root.get(field)),
                            value.toLowerCase() + "%"
                    );

                case "ew":
                    return criteriaBuilder.like(
                            criteriaBuilder.lower(root.get(field)),
                            "%" + value.toLowerCase()
                    );

                default:
                    throw new NotValidOperatorException("Invalid operator");
            }
        };
    }
}
