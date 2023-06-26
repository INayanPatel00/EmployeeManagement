package com.infoWare.demo.controller;

import com.infoWare.demo.DTO.AddressDTO;
import com.infoWare.demo.DTO.EmergencyContactDTO;
import com.infoWare.demo.DTO.EmployeeDTO;
import com.infoWare.demo.DTO.JobDTO;
import com.infoWare.demo.services.serviceInterface.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

private final EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("")
    public String viewAll(Model model) {
        List<EmployeeDTO> list =employeeService.getAll();
        model.addAttribute("list", list);
        return "view";

    }
    @GetMapping("/add")
    public String add(Model model) {

       EmployeeDTO employeeDTO =new EmployeeDTO();
        model.addAttribute("user", employeeDTO);
        return "addForm";
    }
    @PostMapping("/insert")
    public String insert(@ModelAttribute("user")  EmployeeDTO employeeDTO){
        employeeService.insertEmployee(employeeDTO);
        return "redirect:/employees";

    }

    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable("id") int id){
        EmployeeDTO user=employeeService.getById(id);
        model.addAttribute("user", user);
        return "updateForm";
    }
    @PostMapping ("/edit/{id}")
    public String updateStudentDetails(@ModelAttribute("user") EmployeeDTO user, @PathVariable("id") int id)  {
        employeeService.updateDetails(user,id);
        return "redirect:/employees";

    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable("id") int id) {
        employeeService.deleteStudent(id);
        return "redirect:/employees";
    }
}

