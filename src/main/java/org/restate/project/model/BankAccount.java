package org.restate.project.model;

/**
 * Holds bank information for landlords, tenants
 */
public class BankAccount extends BaseObject {

    private String accountNumber;
    private String bankName;
    private String bankBranch;
    private Person personId;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankBranch() {
        return bankBranch;
    }

    public void setBankBranch(String bankBranch) {
        this.bankBranch = bankBranch;
    }

}
