package com.technical.test.technical_test.repositories;



import com.technical.test.technical_test.entity.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Long> {
    
    User findByUsername(String username);
}
