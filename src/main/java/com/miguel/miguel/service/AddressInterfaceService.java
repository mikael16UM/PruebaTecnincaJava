package com.miguel.miguel.service;

import com.miguel.miguel.dto.AddressRequestDto;
import com.miguel.miguel.dto.AddressResponseDto;
import com.miguel.miguel.model.Address;

import java.util.List;

public interface AddressInterfaceService {

    List<AddressResponseDto> getAddresses();

    AddressResponseDto getAddress(long id);

    AddressRequestDto addAddress(AddressRequestDto address_request_dto);

    void deleteAddress(AddressRequestDto address_request_dto);
}
