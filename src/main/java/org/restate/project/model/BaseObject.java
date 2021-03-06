package org.restate.project.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Defines properties of base object like id and name.
 * Should be extended by other classes
 */
public abstract class BaseObject implements Serializable {
    private String uuid;
    private Integer id;
    private String name;
    private Date dateCreated;
    private Person createdBy;
    private boolean voided;
    private Person voidedBy;
    private Date dateVoided;


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

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Person getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Person createdBy) {
        this.createdBy = createdBy;
    }

    public boolean isVoided() {
        return voided;
    }

    public void setVoided(boolean voided) {
        this.voided = voided;
    }

    public Person getVoidedBy() {
        return voidedBy;
    }

    public void setVoidedBy(Person voidedBy) {
        this.voidedBy = voidedBy;
    }

    public Date getDateVoided() {
        return dateVoided;
    }

    public void setDateVoided(Date dateVoided) {
        this.dateVoided = dateVoided;
    }
}
