package org.restate.project.DAO.hibernate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.restate.project.DAO.TenancyAgreementDAO;
import org.restate.project.model.TenancyAgreement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * TODO:please provide a brief description for the class.
 */
public class TenancyAgreementHibernateDao implements TenancyAgreementDAO {

    @Autowired
    private SessionFactory sessionfactory;

    private Log log = LogFactory.getLog(this.getClass());

    @Transactional
    @Override
    public TenancyAgreement saveTenancyAgreement(TenancyAgreement tenancyAgreement) {
        sessionfactory.getCurrentSession().saveOrUpdate(tenancyAgreement);
        log.info("TenancyAgreement saved successfully");
        return tenancyAgreement;
    }

    @Transactional
    @Override
    public TenancyAgreement getTenancyAgreementByRef(String ref) {
        return (TenancyAgreement)sessionfactory.getCurrentSession().get(TenancyAgreement.class,ref);
    }

    @Transactional
    @Override
    public List<TenancyAgreement> getTenancyAgreementList() {
        Criteria criteria = sessionfactory.getCurrentSession().createCriteria(TenancyAgreement.class);
        log.info("Got this number of Tenancy Agreements "+ criteria.list().size());
        criteria.addOrder(Order.asc("id"));
        return criteria.list();
    }

    @Transactional
    @Override
    public TenancyAgreement getTenancyAgreementById(Integer id) {
        return (TenancyAgreement)sessionfactory.getCurrentSession().get(TenancyAgreement.class,id);
    }
}
