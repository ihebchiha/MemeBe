package com.gobeyond.memebe.mapper;

import com.gobeyond.memebe.domain.Address;
import com.gobeyond.memebe.domain.dto.AddressDto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class AddressMapper {

    @Autowired
    private ModelMapper modelMapper;

    public AddressDto toDto(Address address) {
        return modelMapper.map(address, AddressDto.class);
    }

    public Address toEntity(AddressDto addressDto) {
        return modelMapper.map(addressDto, Address.class);
    }
}
