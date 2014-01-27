package org.restate.project.DAO.hibernate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.restate.project.DAO.EnquiryDAO;
import org.restate.project.model.Enquiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * TODO:please provide a brief description for the class.
 */
public class EnquiryHibernateDao implements EnquiryDAO {

    @Autowired
    private SessionFactory sessionfactory;

    private Log log = LogFactory.getLog(this.getClass());

    @Transactional
    @Override
    public Enquiry saveEnquiry(Enquiry enquiry) {
        sessionfactory.getCurrentSession().saveOrUpdate(enquiry);
        log.info("Enquiry saved successfully");
        return enquiry;
    }

    @Transactional
    @Override
    public List<Enquiry> getEnquiryList() {
        Criteria criteria = sessionfactory.getCurrentSession().createCriteria(Enquiry.class);
        log.info("Got this number of Enquiries "+ criteria.list().size());
        criteria.addOrder(Order.asc("id"));
        return criteria.list();
    }

    @Transactional
    @Override
    public Enquiry getEnquiryById(Integer id) {
        return (Enquiry)sessionfactory.getCurrentSession().get(Enquiry.class,id);
    }
}
