package org.restate.project.DAO.hibernate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.restate.project.DAO.CountryDAO;
import org.restate.project.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * TODO:please provide a brief description for the class.
 */
public class CountryHibernateDao implements CountryDAO {

    @Autowired
    private SessionFactory sessionfactory;

    private Log log = LogFactory.getLog(this.getClass());

    @Transactional
    @Override
    public Country saveCountry(Country country) {
        sessionfactory.getCurrentSession().saveOrUpdate(country);
        return country;
    }

    @Transactional
    @Override
    public Country getCountryByCode(String code) {
        return (Country)sessionfactory.getCurrentSession().get(Country.class,code);
    }

    @Transactional
    @Override
    public List<Country> getCountryList() {
        Criteria criteria = sessionfactory.getCurrentSession().createCriteria(Country.class);
        criteria.addOrder(Order.asc("code"));
        return criteria.list();
    }

    @Transactional
    @Override
    public Country getCountryById(Integer id) {
        return (Country)sessionfactory.getCurrentSession().get(Country.class,id);
    }
}
