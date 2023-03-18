package com.gb.DanismanPortal.mapper;

import com.gb.DanismanPortal.entity.Company;
import com.gb.DanismanPortal.response.CompanyResponse;
import com.gb.DanismanPortal.request.Company.CompanyAddRequest;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompanyMapper {
    List<CompanyResponse> toCompanyResponseList (List<Company> companyies);
    CompanyResponse toCompanyResponse (Company company);
    Company toCompany (CompanyAddRequest companyAddRequest);
}
