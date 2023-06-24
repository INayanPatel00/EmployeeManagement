package com.infoWare.demo.DTO;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class AddressDTO {
    private int id;
    private String addressLine;
    private String city;
    private String state;

    public AddressDTO(String addressLine, String city, String state) {
        this.addressLine = addressLine;
        this.city = city;
        this.state = state;
    }


    public AddressDTO(AddressDTO addressDTO) {
    }
}
