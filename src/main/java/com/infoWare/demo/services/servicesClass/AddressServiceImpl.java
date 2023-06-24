package com.infoWare.demo.services.servicesClass;

import com.infoWare.demo.DTO.AddressDTO;
import com.infoWare.demo.entity.Address;
import com.infoWare.demo.repository.AddressRepository;
import com.infoWare.demo.services.serviceInterface.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {
    public  final AddressRepository addressRepository;
@Autowired
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public void insertAddress(Address address) {

        addressRepository.save(address);
    }
}
