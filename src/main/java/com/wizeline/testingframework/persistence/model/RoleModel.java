package com.wizeline.testingframework.persistence.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;

/**
 * PrivilegeModel object
 */
@Document(collection = "role")
public class RoleModel {
    @Id
    private String id;
    private String name;

    @DBRef
    private Collection<PrivilegeModel> privileges;

    public RoleModel(String name, Collection<PrivilegeModel> privileges) {
        this.name = name;
        this.privileges = privileges;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<PrivilegeModel> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(Collection<PrivilegeModel> privileges) {
        this.privileges = privileges;
    }
}
