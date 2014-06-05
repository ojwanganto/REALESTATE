package org.restate.project.service;

import org.restate.project.model.Agent;
import org.restate.project.model.PaymentType;

import java.util.List;

/**
 * service class for Agent class
 */
public interface PaymentTypeService {

    public PaymentType savePaymentType(PaymentType paymentType);
    public PaymentType getPaymentTypeById(Integer id);
    public List<PaymentType> getPaymentTypeList();

}
