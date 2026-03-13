package com.miguel.miguel.service;

import com.miguel.miguel.dto.AddressRequestDto;
import com.miguel.miguel.dto.AddressResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService implements AddressInterfaceService{
    @Override
    public List<AddressResponseDto> getAddresses() {
        return List.of();
    }

    @Override
    public AddressResponseDto getAddress(long id) {
        return null;
    }

    @Override
    public AddressResponseDto createAddress(AddressRequestDto address_request_dto) {
        return null;
    }

    @Override
    public void deleteAddress(AddressRequestDto address_request_dto) {

    }
}
