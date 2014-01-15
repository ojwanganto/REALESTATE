package org.restate.project.model;

import java.io.Serializable;

/**
 * Defines properties of base object like id and name.
 * Should be extended by other classes
 */
public abstract class BaseObject implements Serializable {
    private String uuid;
    private Integer id;
    private String name;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
