package com.wizeline.testingframework.persistence.repository;

import com.wizeline.testingframework.persistence.model.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * The UserRepository to work with {@link UserModel}
 */
public interface UserRepository extends MongoRepository<UserModel, String> {

    UserModel findByEmail(String email);

}
