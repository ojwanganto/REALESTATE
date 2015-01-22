package org.restate.project.model;

/**
 * Captures payment details
 */
public class Payment extends BaseObject {

	private String description;
    private PaymentType paymentType;
	private PaymentMode paymentMode;
	private Integer paymentInOut;
    private Tenant tenant;
    private Unit unit;
    private Double amount;
    private String paymentPeriod;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

	public PaymentMode getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(PaymentMode paymentMode) {
		this.paymentMode = paymentMode;
	}

	public Integer getPaymentInOut() {
		return paymentInOut;
	}

	public void setPaymentInOut(Integer paymentInOut) {
		this.paymentInOut = paymentInOut;
	}

	public String getPaymentPeriod() {
		return paymentPeriod;
	}

	public void setPaymentPeriod(String paymentPeriod) {
		this.paymentPeriod = paymentPeriod;
	}
}
