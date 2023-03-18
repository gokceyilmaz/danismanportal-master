package com.gb.DanismanPortal.service.Impl;

import com.gb.DanismanPortal.entity.Company;
import com.gb.DanismanPortal.exception.ObjectNotFoundException;
import com.gb.DanismanPortal.mapper.CompanyMapper;
import com.gb.DanismanPortal.repository.CompanyRepository;
import com.gb.DanismanPortal.request.Company.CompanyAddRequest;
import com.gb.DanismanPortal.request.Company.CompanyUpdateRequest;
import com.gb.DanismanPortal.response.CompanyResponse;
import com.gb.DanismanPortal.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;

    @Override
    public List<CompanyResponse> listAll(){
        List<Company> companies = companyRepository.findAll();
        List<CompanyResponse> companyResponses = companyMapper.toCompanyResponseList(companies);
        return companyResponses;
    }

    @Override
    public CompanyResponse save(CompanyAddRequest companyAddRequest) {
        Company company = companyMapper.toCompany(companyAddRequest);
        Company saved = companyRepository.save(company);
        return companyMapper.toCompanyResponse(saved);
    }

    @Override
    public CompanyResponse update (CompanyUpdateRequest companyUpdateRequest){
        Optional<Company> company = companyRepository.findById(companyUpdateRequest.getId());
        if(company.isPresent()){
            BeanUtils.copyProperties(companyUpdateRequest, company.get());
            Company savedCompany = companyRepository.save(company.get());
            return companyMapper.toCompanyResponse(savedCompany);
        }
        else{
            throw new ObjectNotFoundException("Company Not Found!");
        }
    }

    @Override
    public void delete(Integer id){
        Optional<Company> company = companyRepository.findById(id);
        if(company.isPresent()){
            company.get().setEndTime(LocalDate.now());
            companyRepository.save(company.get());
        }
    }
}
