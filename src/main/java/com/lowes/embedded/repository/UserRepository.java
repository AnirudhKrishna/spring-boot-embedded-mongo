package com.lowes.embedded.repository;


import com.lowes.embedded.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

     User findByEmail(String email);

   User findByName(String firstName);


}
