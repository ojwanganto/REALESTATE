package org.restate.project.DAO;

import org.restate.project.model.Agent;
import org.restate.project.model.PaymentType;

import java.util.List;

/**
 * TODO:please provide a brief description for the class.
 */
public interface PaymentTypeDAO {
    public PaymentType savePaymentType(PaymentType paymentType);
    public PaymentType getPaymentTypeById(Integer id);
    public List<PaymentType> getPaymentTypeList();
}
