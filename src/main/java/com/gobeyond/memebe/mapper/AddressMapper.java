package com.gobeyond.memebe.mapper;

import com.gobeyond.memebe.domain.Address;
import com.gobeyond.memebe.domain.dto.AddressDto;

import org.mapstruct.Mapper;

@Mapper
public interface AddressMapper {

    AddressDto toDto(Address address);

    Address toEntity(AddressDto addressDto);
}
