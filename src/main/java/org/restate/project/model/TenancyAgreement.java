package org.restate.project.model;

import java.util.Currency;
import java.util.Date;

/**
 * Defines an agreement between tenant and agent/landlord/lady
 */
public class TenancyAgreement extends BaseObject {

    private String referenceNumber;
    private Tenant tenant;
    private Landlord landlord;
    private Unit unit;
    private Date startDate;
    private Date expiry;
    private Currency fee;


    //default constructor
    public TenancyAgreement(){

    }

    public TenancyAgreement(String referenceNumber,Tenant tenant,Landlord landlord,Unit unit,Date startDate,
                            Date expiry,
                            Currency fee){
       this.referenceNumber = referenceNumber;
       this.tenant = tenant;
       this.landlord = landlord;
       this.unit = unit;
       this.startDate = startDate;
       this.expiry = expiry;
       this.fee = fee;
    }


    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public Landlord getLandlord() {
        return landlord;
    }

    public void setLandlord(Landlord landlord) {
        this.landlord = landlord;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }


    public Date getExpiry() {
        return expiry;
    }

    public void setExpiry(Date expiry) {
        this.expiry = expiry;
    }

    public Currency getFee() {
        return fee;
    }

    public void setFee(Currency fee) {
        this.fee = fee;
    }
}
