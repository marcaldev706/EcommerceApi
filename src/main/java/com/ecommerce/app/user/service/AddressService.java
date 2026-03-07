package com.ecommerce.app.user.service;

import com.ecommerce.app.user.entity.AddressEntity;
import com.ecommerce.app.user.entity.UserEntity;
import com.ecommerce.app.user.exception.IdDoesNotBelong;
import com.ecommerce.app.user.exception.NoAddressFound;
import com.ecommerce.app.user.exception.NoUserFound;
import com.ecommerce.app.user.repository.AddressRepository;
import com.ecommerce.app.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final UserRepository userRepository;


    public AddressEntity create(Long userId, AddressEntity address) {

        UserEntity user = findUserOrThrow(userId);

        address.setUser(user);

        return addressRepository.save(address);
    }


    public AddressEntity update(Long userId, Long addressId, AddressEntity newAddress) {

        AddressEntity address = findAddressOrThrow(addressId);

        validateOwnership(userId, address);

        address.setStreet(newAddress.getStreet());
        address.setNeighborhood(newAddress.getNeighborhood());
        address.setZipCode(newAddress.getZipCode());
        address.setNumber(newAddress.getNumber());

        return addressRepository.save(address);
    }


    public AddressEntity findById(Long userId, Long addressId) {

        AddressEntity address = findAddressOrThrow(addressId);

        validateOwnership(userId, address);

        return address;
    }


    public List<AddressEntity> listAll( ) {
        return addressRepository.findAll();
    }


    public void delete(Long userId, Long addressId) {

        AddressEntity address = findAddressOrThrow(addressId);

        validateOwnership(userId, address);

        addressRepository.delete(address);
    }


    private UserEntity findUserOrThrow(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new NoUserFound(userId));
    }


    private AddressEntity findAddressOrThrow(Long addressId) {
        return addressRepository.findById(addressId)
                .orElseThrow(() -> new NoAddressFound(addressId));
    }


    private void validateOwnership(Long userId, AddressEntity address) {
        if (!address.getUser().getId().equals(userId)) {
            throw new IdDoesNotBelong();
        }
    }
}
