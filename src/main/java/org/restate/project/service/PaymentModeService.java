package org.restate.project.service;

import org.restate.project.model.PaymentMode;

import java.util.List;

/**
 * service class for PaymentMode class
 */
public interface PaymentModeService {

    public PaymentMode savePaymentMode(PaymentMode paymentMode);
    public PaymentMode getPaymentModeById(Integer id);
    public List<PaymentMode> getPaymentModeList();

}
