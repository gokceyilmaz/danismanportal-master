package com.gb.DanismanPortal.service;

import com.gb.DanismanPortal.response.AddressResponse;
import com.gb.DanismanPortal.request.Address.AddressAddRequest;
import com.gb.DanismanPortal.request.Address.AddressUpdateRequest;

import java.util.List;

public interface AddressService {
    List<AddressResponse> listAll();
    AddressResponse save(AddressAddRequest addressAddRequest);
    AddressResponse update(AddressUpdateRequest addressUpdateRequest);
    void delete(Integer id);
}
