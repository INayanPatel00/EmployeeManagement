package com.infoWare.demo.services.servicesClass;

import com.infoWare.demo.DTO.JobDTO;
import com.infoWare.demo.entity.Job;
import com.infoWare.demo.repository.JobRepository;
import com.infoWare.demo.services.serviceInterface.JobServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobServicesImpl implements JobServices {
    public final JobRepository jobRepository;
@Autowired
    public JobServicesImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public void insertJob(Job job){
    jobRepository.save(job);

    }

}
