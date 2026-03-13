package com.miguel.miguel.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressResponseDto {

    private long id;
    private String name;
    private String street;
    private String country_code;
}
