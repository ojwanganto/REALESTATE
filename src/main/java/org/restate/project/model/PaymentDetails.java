package org.restate.project.model;

/**
 * Model class for PaymentDetails i.e additional payment information
 */
public class PaymentDetails extends BaseObject{

    private Payment payment;
    private String bankName;
    private String bankBranch;
    private String bankTransactionNo;
	private String mobileMoneyTransactionCode;
	private String mobileNumber;

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
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

	public String getBankTransactionNo() {
		return bankTransactionNo;
	}

	public void setBankTransactionNo(String bankTransactionNo) {
		this.bankTransactionNo = bankTransactionNo;
	}

	public String getMobileMoneyTransactionCode() {
		return mobileMoneyTransactionCode;
	}

	public void setMobileMoneyTransactionCode(String mobileMoneyTransactionCode) {
		this.mobileMoneyTransactionCode = mobileMoneyTransactionCode;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
}
