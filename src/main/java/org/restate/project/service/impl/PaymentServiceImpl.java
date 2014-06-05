package org.restate.project.service.impl;

import org.restate.project.DAO.AgentDAO;
import org.restate.project.DAO.PaymentDAO;
import org.restate.project.model.Agent;
import org.restate.project.model.Payment;
import org.restate.project.service.AgentService;
import org.restate.project.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * implementation class for AgentService class
 */
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDAO paymentDAO;

    @Override
    public Payment savePayment(Payment payment) {
        return paymentDAO.savePayment(payment);
    }

    @Override
    public Payment getPaymentById(Integer id) {
        return paymentDAO.getPaymentById(id);
    }


}
