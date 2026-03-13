package com.miguel.miguel.mapper;

import com.miguel.miguel.dto.AddressResponseDto;
import com.miguel.miguel.model.Address;

public class AddressMapper {

    public static AddressResponseDto toAddressResponsetDto(Address address) {
        if (address == null) return null;

        return AddressResponseDto.builder()
                .id(address.getId())
                .name(address.getName())
                .street(address.getStreet())
                .country_code(address.getCountry_code())
                .build();

    }
}
