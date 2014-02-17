package org.restate.project.DAO.hibernate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.restate.project.DAO.LandlordAgreementDAO;
import org.restate.project.model.LandlordAgreement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * TODO:please provide a brief description for the class.
 */
public class LandlordAgreementHibernateDao implements LandlordAgreementDAO {

    @Autowired
    private SessionFactory sessionfactory;

    private Log log = LogFactory.getLog(this.getClass());

    @Transactional
    @Override
    public LandlordAgreement saveLandlordAgreement(LandlordAgreement landlordAgreement) {
        sessionfactory.getCurrentSession().saveOrUpdate(landlordAgreement);
        log.info("LandlordAgreement saved successfully");
        return landlordAgreement;
    }

    @Transactional
    @Override
    public LandlordAgreement getLandlordAgreementByRef(String ref) {
        return (LandlordAgreement)sessionfactory.getCurrentSession().get(LandlordAgreement.class,ref);
    }

    @Transactional
    @Override
    public LandlordAgreement getLandlordAgreementById(Integer id) {
        return (LandlordAgreement)sessionfactory.getCurrentSession().get(LandlordAgreement.class,id);
    }

    @Transactional
    @Override
    public List<LandlordAgreement> getLandlordAgreementList() {
        Criteria criteria = sessionfactory.getCurrentSession().createCriteria(LandlordAgreement.class);
        log.info("Got this number of Landlord Agreements "+ criteria.list().size());
        criteria.addOrder(Order.asc("id"));
        return criteria.list();
    }
}
