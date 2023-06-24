package com.infoWare.demo.services.serviceInterface;

import com.infoWare.demo.DTO.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
   void insertEmployee(EmployeeDTO employeeDTO);
   List<EmployeeDTO> getAll();


    EmployeeDTO getById(int id);

    void updateDetails(EmployeeDTO user, int id);

    void deleteStudent(int id);
}
