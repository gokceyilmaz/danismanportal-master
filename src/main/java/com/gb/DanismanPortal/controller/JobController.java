package com.gb.DanismanPortal.controller;

import com.gb.DanismanPortal.constants.Constants;
import com.gb.DanismanPortal.request.Job.JobAddRequest;
import com.gb.DanismanPortal.request.Job.JobUpdateRequest;
import com.gb.DanismanPortal.response.JobResponse;
import com.gb.DanismanPortal.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/job")
public class JobController {
    private final JobService jobService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public ResponseEntity<?> getAll(){
         List<JobResponse> jobResponses = jobService.listAll();
         return new ResponseEntity<>(jobResponses, HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public ResponseEntity<?> save(@RequestBody JobAddRequest jobAddRequest){
        jobService.save(jobAddRequest);
        return new ResponseEntity<>(Constants.SAVED_SUCCES_STATUS, HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping
    public ResponseEntity<?> update(@RequestBody JobUpdateRequest jobUpdateRequest){
        jobService.update(jobUpdateRequest);
        return new ResponseEntity<>(Constants.UPDATED_SUCCES_STATUS, HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable("id") int jobId){
        jobService.delete(jobId);
        return new ResponseEntity<>(Constants.DELETED_SUCCESS_STATUS, HttpStatus.OK);
    }

}
