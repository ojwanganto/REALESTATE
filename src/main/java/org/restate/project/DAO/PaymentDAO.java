package org.restate.project.DAO;

import org.restate.project.model.Payment;

/**
 * TODO:please provide a brief description for the class.
 */
public interface PaymentDAO {

    public Payment savePayment(Payment payment);
    public Payment getPaymentById(Integer id);

}
