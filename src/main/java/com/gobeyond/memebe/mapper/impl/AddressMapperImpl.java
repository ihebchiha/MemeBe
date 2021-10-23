package com.gobeyond.memebe.mapper.impl;

import com.gobeyond.memebe.domain.Address;
import com.gobeyond.memebe.domain.dto.AddressDto;
import com.gobeyond.memebe.mapper.AddressMapper;

public class AddressMapperImpl implements AddressMapper {

    @Override
    public AddressDto toDto(Address address) {
        return AddressDto.builder().build();
    }

    @Override
    public Address toEntity(AddressDto addressDto) {
        return new Address();
    }

}