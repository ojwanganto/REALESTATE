package org.restate.project.service.impl;

import org.restate.project.DAO.AgentDAO;
import org.restate.project.DAO.PaymentTypeDAO;
import org.restate.project.model.Agent;
import org.restate.project.model.PaymentType;
import org.restate.project.service.AgentService;
import org.restate.project.service.PaymentTypeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * implementation class for AgentService class
 */
public class PaymentTypeServiceImpl implements PaymentTypeService {

    @Autowired
    private PaymentTypeDAO paymentTypeDAO;

    @Override
    public PaymentType savePaymentType(PaymentType paymentType) {
        return paymentTypeDAO.savePaymentType(paymentType);
    }

    @Override
    public PaymentType getPaymentTypeById(Integer id) {
        return paymentTypeDAO.getPaymentTypeById(id);
    }

    @Override
    public List<PaymentType> getPaymentTypeList() {
        return paymentTypeDAO.getPaymentTypeList();
    }


}
