package com.infoWare.demo.services.servicesClass;

import com.infoWare.demo.DTO.AddressDTO;
import com.infoWare.demo.DTO.EmergencyContactDTO;
import com.infoWare.demo.DTO.EmployeeDTO;
import com.infoWare.demo.DTO.JobDTO;
import com.infoWare.demo.entity.Address;
import com.infoWare.demo.entity.EmergencyContact;
import com.infoWare.demo.entity.Employee;
import com.infoWare.demo.entity.Job;
import com.infoWare.demo.repository.EmployeeRepository;
import com.infoWare.demo.services.serviceInterface.AddressService;
import com.infoWare.demo.services.serviceInterface.EmergencyContactService;
import com.infoWare.demo.services.serviceInterface.EmployeeService;
import com.infoWare.demo.services.serviceInterface.JobServices;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServicesImpl implements EmployeeService {
    private final AddressService addressService;
    private final JobServices jobServices;
    private final EmergencyContactService emergencyContactService;
    private final EmployeeRepository employeeRepository;


    @Autowired
    public EmployeeServicesImpl(AddressServiceImpl addressService, JobServicesImpl jobServices, EmergencyContactServiceImpl emergencyContactService, EmployeeRepository employeeRepository) {
        this.addressService = addressService;
        this.jobServices = jobServices;
        this.emergencyContactService = emergencyContactService;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<EmployeeDTO> getAll() {
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeDTO> employeeDTOS = new ArrayList<>();

        for(Employee employee :employees){

            EmployeeDTO employeeDTO =new EmployeeDTO(employee.getId(),
                    employee.getName(),
                    employee.getPhone(),
                    employee.getEmail(),
                    new AddressDTO(employee.getAddress().getId(),
                            employee.getAddress().getAddressLine(),
                            employee.getAddress().getCity(),
                            employee.getAddress().getState()),
                    new JobDTO(employee.getId(),
                            employee.getJob().getDepartment()),
                    new EmergencyContactDTO(employee.getPrimaryEmergencyContact().getId(),
                            employee.getPrimaryEmergencyContact().getName(),
                            employee.getPrimaryEmergencyContact().getPhone(),
                            employee.getPrimaryEmergencyContact().getRelation(),
                            employee.getSecondaryEmergencyContact().getId(),
                            employee.getSecondaryEmergencyContact().getName(),
                            employee.getSecondaryEmergencyContact().getPhone(),
                            employee.getSecondaryEmergencyContact().getRelation()));
            employeeDTOS.add(employeeDTO);
        }
        return employeeDTOS;
    }

    @Override
    public void insertEmployee(EmployeeDTO employeeDTO) {
        Address address = new Address(employeeDTO.getAddressDTO().getAddressLine(),
                employeeDTO.getAddressDTO().getCity(),
                employeeDTO.getAddressDTO().getState());

        Job job =new Job(employeeDTO.getJobDTO().getDepartment());

        EmergencyContact primaryEmergencyContact =new EmergencyContact(employeeDTO.getEmergencyContactDTO().getPrimaryEmergencyName(),employeeDTO.getEmergencyContactDTO().getPrimaryEmergencyPhone(),employeeDTO.getEmergencyContactDTO().getPrimaryEmergencyRelation());

        EmergencyContact secondaryEmergencyContact =new EmergencyContact(employeeDTO.getEmergencyContactDTO().getSecondaryEmergencyName(),employeeDTO.getEmergencyContactDTO().getSecondaryEmergencyPhone(),employeeDTO.getEmergencyContactDTO().getSecondaryEmergencyRelation());
        addressService.insertAddress(address);
        jobServices.insertJob(job);
        emergencyContactService.insertEmergencyContact(primaryEmergencyContact);
        emergencyContactService.insertEmergencyContact(secondaryEmergencyContact);

        Employee employee =new Employee(employeeDTO.getName(),
                employeeDTO.getPhone(),
                employeeDTO.getEmail(),
                address,
                primaryEmergencyContact,
                secondaryEmergencyContact,
                job);

        employeeRepository.save(employee);
    }

    public EmployeeDTO getById(int id){

        Optional<Employee> employee=employeeRepository.findById(id);
        EmployeeDTO employeeDTO =new EmployeeDTO(employee.get().getId(),employee.get().getName(),
                employee.get().getPhone(),
                employee.get().getEmail(),
                new AddressDTO(employee.get().getAddress().getAddressLine(),
                        employee.get().getAddress().getCity(),
                        employee.get().getAddress().getState()),
                new JobDTO(employee.get().getJob().getDepartment()),
                new EmergencyContactDTO(employee.get().getPrimaryEmergencyContact().getName(),
                        employee.get().getPrimaryEmergencyContact().getPhone(),
                        employee.get().getPrimaryEmergencyContact().getRelation(),
                        employee.get().getSecondaryEmergencyContact().getName(),
                        employee.get().getSecondaryEmergencyContact().getPhone(),
                        employee.get().getSecondaryEmergencyContact().getRelation()));
    return employeeDTO;

    }
   public void updateDetails(EmployeeDTO employeeDTO, int id){
     Address address = new Address(employeeDTO.getAddressDTO().getAddressLine(),
             employeeDTO.getAddressDTO().getCity(),
             employeeDTO.getAddressDTO().getState());
     addressService.insertAddress(address);

     Job job =new Job(employeeDTO.getJobDTO().getDepartment());
     jobServices.insertJob(job);

     EmergencyContact primaryEmergencyContact =new EmergencyContact(employeeDTO.getEmergencyContactDTO().getPrimaryEmergencyName(),employeeDTO.getEmergencyContactDTO().getPrimaryEmergencyPhone(),employeeDTO.getEmergencyContactDTO().getPrimaryEmergencyRelation());
     EmergencyContact secondaryEmergencyContact =new EmergencyContact(employeeDTO.getEmergencyContactDTO().getSecondaryEmergencyName(),employeeDTO.getEmergencyContactDTO().getSecondaryEmergencyPhone(),employeeDTO.getEmergencyContactDTO().getSecondaryEmergencyRelation());

     emergencyContactService.insertEmergencyContact(primaryEmergencyContact);
     emergencyContactService.insertEmergencyContact(secondaryEmergencyContact);

       Employee employee =new Employee(id,
               employeeDTO.getName(),
               employeeDTO.getPhone(),
               employeeDTO.getEmail(),
               address,
               primaryEmergencyContact,
               secondaryEmergencyContact,
               job);

       employeeRepository.save(employee);

   }
    public void deleteStudent(int id) {
        employeeRepository.deleteById(id);

    }
}
