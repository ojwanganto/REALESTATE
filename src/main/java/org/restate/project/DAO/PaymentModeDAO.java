package org.restate.project.DAO;

import org.restate.project.model.PaymentMode;

import java.util.List;

/**
 * TODO:please provide a brief description for the class.
 */
public interface PaymentModeDAO {
	public PaymentMode savePaymentMode(PaymentMode paymentMode);
	public PaymentMode getPaymentModeById(Integer id);
	public List<PaymentMode> getPaymentModeList();
}
