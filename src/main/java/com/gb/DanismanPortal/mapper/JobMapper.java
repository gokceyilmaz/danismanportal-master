package com.gb.DanismanPortal.mapper;

import com.gb.DanismanPortal.entity.Job;
import com.gb.DanismanPortal.response.JobResponse;
import com.gb.DanismanPortal.request.Job.JobAddRequest;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface JobMapper {
    List<JobResponse> toJobResponseList (List<Job> jobs);
    JobResponse toJobResponse (Job job);
    Job toJob (JobAddRequest jobAddRequest);

}
