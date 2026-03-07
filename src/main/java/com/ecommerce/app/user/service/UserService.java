package com.ecommerce.app.user.service;

import com.ecommerce.app.user.entity.UserEntity;
import com.ecommerce.app.user.exception.NoUserFound;
import com.ecommerce.app.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public UserEntity create(UserEntity user) {

        user.setCreatedAt(LocalDateTime.now());

        return userRepository.save(user);
    }


    public UserEntity update(UserEntity newUser, Long id) {

        UserEntity user = findUserOrThrow(id);

        user.setName(newUser.getName());
        user.setRg(newUser.getRg());
        user.setCpf(newUser.getCpf());
        user.setEmail(newUser.getEmail());

        return userRepository.save(user);
    }


    public UserEntity findById(Long id) {
        return findUserOrThrow(id);
    }


    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }


    public void delete(Long id) {

        UserEntity user = findUserOrThrow(id);

        userRepository.delete(user);
    }


    private UserEntity findUserOrThrow(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NoUserFound(id));
    }

}
