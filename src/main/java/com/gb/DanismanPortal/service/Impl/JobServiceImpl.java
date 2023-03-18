package com.gb.DanismanPortal.service.Impl;

import com.gb.DanismanPortal.entity.Job;
import com.gb.DanismanPortal.exception.ObjectNotFoundException;
import com.gb.DanismanPortal.mapper.JobMapper;
import com.gb.DanismanPortal.repository.JobRepository;
import com.gb.DanismanPortal.request.Job.JobAddRequest;
import com.gb.DanismanPortal.request.Job.JobUpdateRequest;
import com.gb.DanismanPortal.response.JobResponse;
import com.gb.DanismanPortal.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class JobServiceImpl implements JobService {
    private final JobRepository jobRepository;
    private final JobMapper jobMapper;

    @Override
    public List<JobResponse> listAll(){
        List<Job> jobs = jobRepository.findAll();
        List<JobResponse> jobResponse = jobMapper.toJobResponseList(jobs);
        return jobResponse;
    }

    @Override
    public JobResponse save(JobAddRequest jobAddRequest) {
        Job job = jobMapper.toJob(jobAddRequest);
        Job saved = jobRepository.save(job);
        return jobMapper.toJobResponse(saved);
    }

    @Override
    public JobResponse update (JobUpdateRequest jobUpdateRequest){
        Optional<Job> job = jobRepository.findById(jobUpdateRequest.getId());
        if(job.isPresent()){
            BeanUtils.copyProperties(jobUpdateRequest, job.get());
            Job savedJob = jobRepository.save(job.get());
            return jobMapper.toJobResponse(savedJob);
        }
        else{
            throw new ObjectNotFoundException("Job Not Found!");
        }
    }

    @Override
    public void delete(Integer id){
        Optional<Job> job = jobRepository.findById(id);
        if(job.isPresent()){
            job.get().setEndTime(LocalDate.now());
            jobRepository.save(job.get());
        }
    }

}

