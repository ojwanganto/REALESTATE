package org.restate.project.service;

import org.restate.project.model.Agent;
import org.restate.project.model.Payment;

import java.util.List;

/**
 * service class for Payment class
 */
public interface PaymentService {

    public Payment savePayment(Payment payment);
    public Payment getPaymentById(Integer id);
    public List<Payment> getPaymentList();

}
