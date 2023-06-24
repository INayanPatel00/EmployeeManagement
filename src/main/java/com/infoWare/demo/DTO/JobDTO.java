package com.infoWare.demo.DTO;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class JobDTO {
    private int id;
    private String department;

    public JobDTO(String department) {
        this.department = department;
    }



}

