package com.wizeline.testingframework.persistence.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * PrivilegeModel object
 */
@Document(collection = "privilege")
public class PrivilegeModel {

    @Id
    private String id;
    private String name;

    public PrivilegeModel(String name) {
        this.name = name;
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
}
