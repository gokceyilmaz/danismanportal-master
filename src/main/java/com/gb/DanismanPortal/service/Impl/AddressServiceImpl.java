package com.gb.DanismanPortal.service.Impl;

import com.gb.DanismanPortal.entity.Address;
import com.gb.DanismanPortal.exception.ObjectNotFoundException;
import com.gb.DanismanPortal.mapper.AddressMapper;
import com.gb.DanismanPortal.response.AddressResponse;
import com.gb.DanismanPortal.repository.AddressRepository;
import com.gb.DanismanPortal.request.Address.AddressAddRequest;
import com.gb.DanismanPortal.request.Address.AddressUpdateRequest;
import com.gb.DanismanPortal.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    @Override
    public List<AddressResponse> listAll(){
        List<Address> addresses = addressRepository.findAll();
        List<AddressResponse> addressResponse = addressMapper.toAdressResponseList(addresses);
        return addressResponse;
    }

    @Override
    public AddressResponse save(AddressAddRequest addressAddRequest) {
        Address address = addressMapper.toAddress(addressAddRequest);
        Address saved = addressRepository.save(address);
        return addressMapper.toAdressResponse(saved);
    }

    @Override
    public AddressResponse update (AddressUpdateRequest addressUpdateRequest){
        Optional<Address> adress = addressRepository.findById(addressUpdateRequest.getId());
        if(adress.isPresent()){
            BeanUtils.copyProperties(addressUpdateRequest, adress.get());
            Address savedAddress = addressRepository.save(adress.get());
            return addressMapper.toAdressResponse(savedAddress);
        }
        else{
            throw new ObjectNotFoundException("Adress Bulunamadı!");
        }
    }

    @Override
    public void delete(Integer id){
        Optional<Address> address = addressRepository.findById(id);
        if(address.isPresent()){
            address.get().setEndTime(LocalDate.now());
            addressRepository.save(address.get());
        }
    }

}
