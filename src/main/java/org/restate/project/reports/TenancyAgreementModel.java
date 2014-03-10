package org.restate.project.reports;

import org.restate.project.model.Agent;
import org.restate.project.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * A model for Tenancy Agreement document
 */
public class TenancyAgreementModel {

    private String currentDate;

    private String agentName;
    private String agentAddress;
    private String agentCellPhone;

    private String houseName;
    private String tenantName;
    private String tenantAddress;
    private String tenantCellPhone;
    private String tenantIDNo;
    private String effectiveDate;
    private String expiryDate;
    private String rent;

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

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getTenantAddress() {
        return tenantAddress;
    }

    public void setTenantAddress(String tenantAddress) {
        this.tenantAddress = tenantAddress;
    }

    public String getTenantCellPhone() {
        return tenantCellPhone;
    }

    public void setTenantCellPhone(String tenantCellPhone) {
        this.tenantCellPhone = tenantCellPhone;
    }

    public String getTenantIDNo() {
        return tenantIDNo;
    }

    public void setTenantIDNo(String tenantIDNo) {
        this.tenantIDNo = tenantIDNo;
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

    public String getRent() {
        return rent;
    }

    public void setRent(String rent) {
        this.rent = rent;
    }
}
