package com.wizeline.testingframework.persistence.repository;

import com.wizeline.testingframework.persistence.model.RoleModel;
import com.wizeline.testingframework.persistence.model.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * The RoleRepository to work with {@link RoleModel}
 */
public interface RoleRepository extends MongoRepository<RoleModel, String> {

    UserModel findByName(String name);
}
