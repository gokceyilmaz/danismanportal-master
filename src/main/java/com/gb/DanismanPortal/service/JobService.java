package com.gb.DanismanPortal.service;

import com.gb.DanismanPortal.response.JobResponse;
import com.gb.DanismanPortal.request.Job.JobAddRequest;
import com.gb.DanismanPortal.request.Job.JobUpdateRequest;

import java.util.List;

public interface JobService {
    List<JobResponse> listAll();
    JobResponse save(JobAddRequest jobAddRequest);
    JobResponse update(JobUpdateRequest jobUpdateRequest);
    void delete(Integer id);
}
