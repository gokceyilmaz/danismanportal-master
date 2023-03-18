package com.gb.DanismanPortal.controller;

import com.gb.DanismanPortal.constants.Constants;
import com.gb.DanismanPortal.request.Company.CompanyAddRequest;
import com.gb.DanismanPortal.request.Company.CompanyUpdateRequest;
import com.gb.DanismanPortal.response.CompanyResponse;
import com.gb.DanismanPortal.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/company")
public class CompanyController {
    private final CompanyService companyService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public ResponseEntity<?> getAll(){
        List<CompanyResponse> companyResponses = companyService.listAll();
        return new ResponseEntity<>(companyResponses, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody CompanyAddRequest companyAddRequest){
        companyService.save(companyAddRequest);
        return new ResponseEntity<>(Constants.SAVED_SUCCES_STATUS, HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<?> update(@RequestBody CompanyUpdateRequest companyUpdateRequest){
        companyService.update(companyUpdateRequest);
        return new ResponseEntity<>(Constants.UPDATED_SUCCES_STATUS, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable("id") int companyId){
        companyService.delete(companyId);
        return new ResponseEntity<>(Constants.DELETED_SUCCESS_STATUS, HttpStatus.OK);
    }
}
