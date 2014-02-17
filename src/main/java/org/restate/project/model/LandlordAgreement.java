package org.restate.project.model;

import java.util.Date;

/**
 * Holds details for Landlord - Agent agreement
 */
public class LandlordAgreement extends BaseObject {
    private Landlord landlord;
    private String referenceNumber;
    private House house;
    private Date effectiveDate = new Date();
    private Date expiryDate = new Date();
    private Date dateOfRentRemittance = new Date();
    private Double commissionOnRent;
    private Date tenantsDeadlineForRentPayment = new Date();

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public Landlord getLandlord() {
        return landlord;
    }

    public void setLandlord(Landlord landlord) {
        this.landlord = landlord;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Date getDateOfRentRemittance() {
        return dateOfRentRemittance;
    }

    public void setDateOfRentRemittance(Date dateOfRentRemittance) {
        this.dateOfRentRemittance = dateOfRentRemittance;
    }

    public Double getCommissionOnRent() {
        return commissionOnRent;
    }

    public void setCommissionOnRent(Double commissionOnRent) {
        this.commissionOnRent = commissionOnRent;
    }

    public Date getTenantsDeadlineForRentPayment() {
        return tenantsDeadlineForRentPayment;
    }

    public void setTenantsDeadlineForRentPayment(Date tenantsDeadlineForRentPayment) {
        this.tenantsDeadlineForRentPayment = tenantsDeadlineForRentPayment;
    }
}
