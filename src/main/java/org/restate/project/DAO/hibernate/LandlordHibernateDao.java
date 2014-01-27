package org.restate.project.DAO.hibernate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.restate.project.DAO.CountryDAO;
import org.restate.project.DAO.LandlordDAO;
import org.restate.project.model.Country;
import org.restate.project.model.Landlord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * TODO:please provide a brief description for the class.
 */
public class LandlordHibernateDao implements LandlordDAO {

    @Autowired
    private SessionFactory sessionfactory;

    private Log log = LogFactory.getLog(this.getClass());


    @Transactional
    @Override
    public Landlord saveLandlord(Landlord landlord) {
        sessionfactory.getCurrentSession().saveOrUpdate(landlord);
        log.info("Landlord saved successfully");
        return landlord;
    }

    @Transactional
    @Override
    public Landlord getLandlordById(Integer id) {
        return  (Landlord)sessionfactory.getCurrentSession().get(Landlord.class,id);
    }

    @Transactional
    @Override
    public List<Landlord> getLandlordList() {
        Criteria criteria = sessionfactory.getCurrentSession().createCriteria(Landlord.class);
        log.info("Got this number of Landlords "+ criteria.list().size());
        criteria.addOrder(Order.asc("id"));
        return criteria.list();
    }
}
