package com.ecommerce.app.user.controller;

import com.ecommerce.app.user.entity.AddressEntity;
import com.ecommerce.app.user.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/addresses")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @PostMapping("/{userId}")
    public ResponseEntity<AddressEntity> create(@PathVariable Long userId,
                                                @RequestBody AddressEntity address){

        AddressEntity savedAddress = addressService.create(userId, address);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedAddress);
    }

    @PutMapping("/{userId}/{addressId}")
    public ResponseEntity<AddressEntity> update(@PathVariable Long userId,
                                                @PathVariable Long addressId,
                                                @RequestBody AddressEntity newAddress){

        AddressEntity updatedAddress = addressService.update(userId, addressId, newAddress);

        return ResponseEntity.ok(updatedAddress);
    }

    @GetMapping("/{userId}/{addressId}")
    public ResponseEntity<AddressEntity> findById(@PathVariable Long userId,
                                                  @PathVariable Long addressId){

        AddressEntity address = addressService.findById(userId, addressId);

        return ResponseEntity.ok(address);
    }

    @GetMapping
    public ResponseEntity<List<AddressEntity>> listAll(){

        List<AddressEntity> addresses = addressService.listAll();

        return ResponseEntity.ok(addresses);
    }

    @DeleteMapping("/{userId}/{addressId}")
    public ResponseEntity<Void> delete(@PathVariable Long userId,
                                       @PathVariable Long addressId){

        addressService.delete(userId, addressId);

        return ResponseEntity.noContent().build();
    }
}
