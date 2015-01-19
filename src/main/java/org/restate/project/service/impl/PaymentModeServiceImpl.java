package org.restate.project.service.impl;

import org.restate.project.DAO.PaymentModeDAO;
import org.restate.project.model.PaymentMode;
import org.restate.project.service.PaymentModeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * implementation class for PaymentModeService class
 */
public class PaymentModeServiceImpl implements PaymentModeService {

    @Autowired
    private PaymentModeDAO paymentModeDAO;

	@Override
	public PaymentMode savePaymentMode(PaymentMode paymentMode) {
		return paymentModeDAO.savePaymentMode(paymentMode);
	}

	@Override
	public PaymentMode getPaymentModeById(Integer id) {
		return paymentModeDAO.getPaymentModeById(id);
	}

	@Override
	public List<PaymentMode> getPaymentModeList() {
		return paymentModeDAO.getPaymentModeList();
	}
}
