package com.gobeyond.memebe.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {

    private String country;
    private String city;
    private String street;
    private String building;
    private Long postalCode;
    private UserDto userDto;
}
