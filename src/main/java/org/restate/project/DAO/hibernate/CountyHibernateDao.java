package org.restate.project.DAO.hibernate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.restate.project.DAO.CountryDAO;
import org.restate.project.DAO.CountyDAO;
import org.restate.project.model.Country;
import org.restate.project.model.County;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * TODO:please provide a brief description for the class.
 */
public class CountyHibernateDao implements CountyDAO {

    @Autowired
    private SessionFactory sessionfactory;

    private Log log = LogFactory.getLog(this.getClass());

    @Transactional
    @Override
    public County saveCounty(County county) {
        sessionfactory.getCurrentSession().saveOrUpdate(county);
        log.info("County saved successfully");
        return county;
    }

    @Transactional
    @Override
    public County getCountyByCode(String code) {
        return (County)sessionfactory.getCurrentSession().get(County.class,code);
    }

    @Transactional
    @Override
    public List<County> getCountyList() {
        Criteria criteria = sessionfactory.getCurrentSession().createCriteria(County.class);
        log.info("Got this number of Counties "+ criteria.list().size());
        criteria.addOrder(Order.asc("id"));
        return criteria.list();
    }

    @Transactional
    @Override
    public County getCountyById(Integer id) {
        return (County)sessionfactory.getCurrentSession().get(County.class,id);
    }
}
