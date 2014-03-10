package org.restate.project.reports;

/**
 * A model for Landlord Agreement document
 */
public class LandlordAgreementModel {

    private String currentDate;
    private String agentName;
    private String agentAddress;
    private String agentCellPhone;


    private String houseName;
    private String landlordName;
    private String landlordAddress;
    private String landlordCellPhone;
    private String landlordIDNo;
    private String effectiveDate;
    private String expiryDate;
    private String commissionOnRent;
    private String dateOfRentSubmission;
    private String tenantRentPaymentDeadline;

    public String getCommissionOnRent() {
        return commissionOnRent;
    }

    public void setCommissionOnRent(String commissionOnRent) {
        this.commissionOnRent = commissionOnRent;
    }

    public String getDateOfRentSubmission() {
        return dateOfRentSubmission;
    }

    public void setDateOfRentSubmission(String dateOfRentSubmission) {
        this.dateOfRentSubmission = dateOfRentSubmission;
    }

    public String getTenantRentPaymentDeadline() {
        return tenantRentPaymentDeadline;
    }

    public void setTenantRentPaymentDeadline(String tenantRentPaymentDeadline) {
        this.tenantRentPaymentDeadline = tenantRentPaymentDeadline;
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getAgentAddress() {
        return agentAddress;
    }

    public void setAgentAddress(String agentAddress) {
        this.agentAddress = agentAddress;
    }

    public String getAgentCellPhone() {
        return agentCellPhone;
    }

    public void setAgentCellPhone(String agentCellPhone) {
        this.agentCellPhone = agentCellPhone;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public String getLandlordName() {
        return landlordName;
    }

    public void setLandlordName(String landlordName) {
        this.landlordName = landlordName;
    }

    public String getLandlordAddress() {
        return landlordAddress;
    }

    public void setLandlordAddress(String landlordAddress) {
        this.landlordAddress = landlordAddress;
    }

    public String getLandlordCellPhone() {
        return landlordCellPhone;
    }

    public void setLandlordCellPhone(String landlordCellPhone) {
        this.landlordCellPhone = landlordCellPhone;
    }

    public String getLandlordIDNo() {
        return landlordIDNo;
    }

    public void setLandlordIDNo(String landlordIDNo) {
        this.landlordIDNo = landlordIDNo;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }
}
