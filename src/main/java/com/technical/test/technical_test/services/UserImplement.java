package com.technical.test.technical_test.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.technical.test.technical_test.entity.User;
import com.technical.test.technical_test.repositories.UserRepository;

@Service
public class UserImplement implements UserService {

    private final UserRepository userRepository;

    
    public UserImplement(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
     
        return (List<User>) userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        
        return userRepository.findById(id);
    }

    @Override
    public boolean saveUser(User user) {
       
        try {
            userRepository.save(user);
            return true;
        } catch (Exception e) {
     
            return false;
        }
    }
    @Override
    public boolean deleteUser(Long id) {
        
        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception e) {
           
            return false;
        }
    }
}
