package com.gb.DanismanPortal.controller;

import com.gb.DanismanPortal.constants.Constants;
import com.gb.DanismanPortal.request.Address.AddressAddRequest;
import com.gb.DanismanPortal.request.Address.AddressUpdateRequest;
import com.gb.DanismanPortal.response.AddressResponse;
import com.gb.DanismanPortal.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/address")
public class AddressController {
    private final AddressService addressService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public ResponseEntity<?> getAll(){
        List<AddressResponse> addressResponses = addressService.listAll();
        return new ResponseEntity<>(addressResponses, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody AddressAddRequest addressAddRequest){
        addressService.save(addressAddRequest);
        return new ResponseEntity<>(Constants.SAVED_SUCCES_STATUS, HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<?> update(@RequestBody AddressUpdateRequest addressUpdateRequest){
        addressService.update(addressUpdateRequest);
        return new ResponseEntity<>(Constants.UPDATED_SUCCES_STATUS, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable("id") int addressId){
        addressService.delete(addressId);
        return new ResponseEntity<>(Constants.DELETED_SUCCESS_STATUS, HttpStatus.OK);
    }

}
