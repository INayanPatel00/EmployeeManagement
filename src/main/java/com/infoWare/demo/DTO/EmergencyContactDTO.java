package com.infoWare.demo.DTO;

import com.infoWare.demo.entity.EmergencyContact;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class EmergencyContactDTO {

    private int person1_id;
    private String primaryEmergencyName;
    private long primaryEmergencyPhone;
    private String primaryEmergencyRelation;
    private int person2_id;
    private String secondaryEmergencyName;
    private long secondaryEmergencyPhone;
    private String secondaryEmergencyRelation;

    public EmergencyContactDTO(String primaryEmergencyName, long primaryEmergencyPhone, String primaryEmergencyRelation, String secondaryEmergencyName, long secondaryEmergencyPhone, String secondaryEmergencyRelation) {
        this.primaryEmergencyName = primaryEmergencyName;
        this.primaryEmergencyPhone = primaryEmergencyPhone;
        this.primaryEmergencyRelation = primaryEmergencyRelation;
        this.secondaryEmergencyName = secondaryEmergencyName;
        this.secondaryEmergencyPhone = secondaryEmergencyPhone;
        this.secondaryEmergencyRelation = secondaryEmergencyRelation;
    }


    public EmergencyContactDTO(EmergencyContact primaryEmergencyContact) {
    }


}
