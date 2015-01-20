package org.restate.project.DAO.hibernate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.restate.project.DAO.PaymentModeDAO;
import org.restate.project.model.PaymentMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * TODO:please provide a brief description for the class.
 */
public class PaymentModeHibernateDao implements PaymentModeDAO {


    @Autowired
    private SessionFactory sessionfactory;

    private Log log = LogFactory.getLog(this.getClass());

	@Transactional
	@Override
	public PaymentMode savePaymentMode(PaymentMode paymentMode) {
		sessionfactory.getCurrentSession().saveOrUpdate(paymentMode);
		return paymentMode;
	}

	@Transactional(readOnly = true)
	@Override
	public PaymentMode getPaymentModeById(Integer id) {
		return (PaymentMode)sessionfactory.getCurrentSession().get(PaymentMode.class,id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<PaymentMode> getPaymentModeList() {
		return sessionfactory.getCurrentSession().createCriteria(PaymentMode.class).list();
	}
}
