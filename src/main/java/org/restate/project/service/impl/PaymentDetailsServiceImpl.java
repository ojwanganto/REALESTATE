package org.restate.project.service.impl;

import org.restate.project.DAO.PaymentDetailsDAO;
import org.restate.project.model.Payment;
import org.restate.project.model.PaymentDetails;
import org.restate.project.service.PaymentDetailsService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * implementation class for AgentService class
 */
public class PaymentDetailsServiceImpl implements PaymentDetailsService {

    @Autowired
    private PaymentDetailsDAO paymentDetailsDAO;


	@Override
	public PaymentDetails savePaymentDetails(PaymentDetails paymentDetails) {
		return paymentDetailsDAO.savePaymentDetails(paymentDetails);
	}

	@Override
	public PaymentDetails getPaymentDetailsByPayment(Payment payment) {
		return paymentDetailsDAO.getPaymentDetailsByPayment(payment);
	}
}
