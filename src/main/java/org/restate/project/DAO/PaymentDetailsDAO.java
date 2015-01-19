package org.restate.project.DAO;

import org.restate.project.model.Payment;
import org.restate.project.model.PaymentDetails;

import java.util.List;

/**
 * DAO layer for paymentdetails service
 */
public interface PaymentDetailsDAO {
	public PaymentDetails savePaymentDetails(PaymentDetails paymentDetails);
	public PaymentDetails getPaymentDetailsByPayment(Payment payment);

}
