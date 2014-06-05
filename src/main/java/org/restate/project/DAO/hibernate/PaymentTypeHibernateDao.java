package org.restate.project.DAO.hibernate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.restate.project.DAO.AgentDAO;
import org.restate.project.DAO.PaymentTypeDAO;
import org.restate.project.model.Agent;
import org.restate.project.model.PaymentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * TODO:please provide a brief description for the class.
 */
public class PaymentTypeHibernateDao implements PaymentTypeDAO {


    @Autowired
    private SessionFactory sessionfactory;

    private Log log = LogFactory.getLog(this.getClass());

    @Transactional
    @Override
    public PaymentType savePaymentType(PaymentType paymentType) {
        sessionfactory.getCurrentSession().saveOrUpdate(paymentType);
        return paymentType;

    }

    @Transactional(readOnly = true)
    @Override
    public PaymentType getPaymentTypeById(Integer id) {
        return (PaymentType)sessionfactory.getCurrentSession().get(PaymentType.class,id);

    }

    @Transactional(readOnly = true)
    @Override
    public List<PaymentType> getPaymentTypeList() {
        return sessionfactory.getCurrentSession().createCriteria(PaymentType.class).list();
    }

}
