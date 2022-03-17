package com.examu.upaxrest.service.Impl;


import com.examu.upaxrest.models.Job;
import com.examu.upaxrest.repository.JobRepo;
import com.examu.upaxrest.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JobServiceImplement implements JobService {
    private final JobRepo jobRepo;


    @Override
    public Job getJob(Long id) {
        Optional <Job> job = jobRepo.findById(id);
        if(job.isPresent()){
            return job.get();
        }
        return null;
    }
}
