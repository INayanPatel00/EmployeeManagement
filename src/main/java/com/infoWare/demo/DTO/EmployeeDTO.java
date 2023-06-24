package com.infoWare.demo.DTO;
import lombok.*;


@NoArgsConstructor
@ToString
@Getter
@Setter
public class EmployeeDTO {
    private int id;
    private String name;
    private long phone;
    private String email;
    private AddressDTO addressDTO;
    private JobDTO jobDTO;
    private EmergencyContactDTO emergencyContactDTO;

    public EmployeeDTO(String name, long phone, String email, AddressDTO addressDTO, JobDTO jobDTO, EmergencyContactDTO emergencyContactDTO) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.addressDTO = addressDTO;
        this.jobDTO = jobDTO;
        this.emergencyContactDTO = emergencyContactDTO;
    }

    public EmployeeDTO(int id, String name, long phone, String email, AddressDTO addressDTO, JobDTO jobDTO, EmergencyContactDTO emergencyContactDTO) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.addressDTO = addressDTO;
        this.jobDTO = jobDTO;
        this.emergencyContactDTO = emergencyContactDTO;
    }

}
