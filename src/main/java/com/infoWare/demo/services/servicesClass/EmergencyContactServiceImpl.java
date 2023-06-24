package com.infoWare.demo.services.servicesClass;

import com.infoWare.demo.entity.EmergencyContact;
import com.infoWare.demo.repository.EmergencyContactRepository;
import com.infoWare.demo.services.serviceInterface.EmergencyContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmergencyContactServiceImpl implements EmergencyContactService {
   public final EmergencyContactRepository emergencyContactRepository;
@Autowired
    public EmergencyContactServiceImpl(EmergencyContactRepository emergencyContactRepository) {
        this.emergencyContactRepository = emergencyContactRepository;
    }

    public void insertEmergencyContact(EmergencyContact emergencyContactDTO) {

        emergencyContactRepository.save(emergencyContactDTO);




    }



}
