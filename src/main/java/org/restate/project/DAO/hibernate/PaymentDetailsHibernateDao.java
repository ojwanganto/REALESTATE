package org.restate.project.DAO.hibernate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.restate.project.DAO.PaymentDAO;
import org.restate.project.DAO.PaymentDetailsDAO;
import org.restate.project.model.Payment;
import org.restate.project.model.PaymentDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Hibernate layer for paymentdetailsdao.
 */
public class PaymentDetailsHibernateDao implements PaymentDetailsDAO {


    @Autowired
    private SessionFactory sessionfactory;

    private Log log = LogFactory.getLog(this.getClass());

    @Transactional
    @Override
	public PaymentDetails savePaymentDetails(PaymentDetails paymentDetails) {
        sessionfactory.getCurrentSession().saveOrUpdate(paymentDetails);

        return paymentDetails;
    }

    @Transactional(readOnly = true)
    @Override
	public PaymentDetails getPaymentDetailsByPayment(Payment payment) {
		Criteria criteria = sessionfactory.getCurrentSession().createCriteria(PaymentDetails.class);
		criteria.add(Restrictions.eq("payment", payment));
		return (PaymentDetails)criteria.list().get(0);

    }

}
