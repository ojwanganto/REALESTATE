package org.restate.project.service;

import org.restate.project.model.Payment;
import org.restate.project.model.PaymentDetails;

/**
 * service class for PaymentDetails class
 */
public interface PaymentDetailsService {

    public PaymentDetails savePaymentDetails(PaymentDetails paymentDetails);
    public PaymentDetails getPaymentDetailsByPayment(Payment payment);


}
