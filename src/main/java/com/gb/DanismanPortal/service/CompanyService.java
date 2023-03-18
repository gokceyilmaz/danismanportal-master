package com.gb.DanismanPortal.service;

import com.gb.DanismanPortal.response.CompanyResponse;
import com.gb.DanismanPortal.request.Company.CompanyAddRequest;
import com.gb.DanismanPortal.request.Company.CompanyUpdateRequest;

import java.util.List;

public interface CompanyService {
    List<CompanyResponse> listAll();
    CompanyResponse save(CompanyAddRequest companyAddRequest);
    CompanyResponse update(CompanyUpdateRequest companyUpdateRequest);
    void delete(Integer id);
}
