package org.restate.project.DAO.hibernate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.restate.project.DAO.AgentDAO;
import org.restate.project.DAO.PaymentDAO;
import org.restate.project.model.Agent;
import org.restate.project.model.LandlordAgreement;
import org.restate.project.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * TODO:please provide a brief description for the class.
 */
public class PaymentHibernateDao implements PaymentDAO {


    @Autowired
    private SessionFactory sessionfactory;

    private Log log = LogFactory.getLog(this.getClass());

    @Transactional
    @Override
    public Payment savePayment(Payment payment) {
        sessionfactory.getCurrentSession().saveOrUpdate(payment);

        return payment;
    }

    @Transactional(readOnly = true)
    @Override
    public Payment getPaymentById(Integer id) {
        return (Payment)sessionfactory.getCurrentSession().get(Payment.class,id);



    }
    @Transactional(readOnly = true)
    @Override
    public List<Payment> getPaymentList() {
        Criteria criteria = sessionfactory.getCurrentSession().createCriteria(Payment.class);
        criteria.addOrder(Order.asc("id"));
        return criteria.list();
    }

}
