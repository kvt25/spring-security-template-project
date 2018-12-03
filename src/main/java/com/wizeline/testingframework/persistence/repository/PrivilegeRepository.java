package com.wizeline.testingframework.persistence.repository;

import com.wizeline.testingframework.persistence.model.PrivilegeModel;
import com.wizeline.testingframework.persistence.model.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * The PrivilegeRepository to work with {@link PrivilegeModel}
 */
public interface PrivilegeRepository extends MongoRepository<PrivilegeModel, String> {

    UserModel findByName(String name);
}
