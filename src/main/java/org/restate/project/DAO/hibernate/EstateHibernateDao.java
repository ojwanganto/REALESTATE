package org.restate.project.DAO.hibernate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.restate.project.DAO.EstateDAO;
import org.restate.project.model.Estate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * TODO:please provide a brief description for the class.
 */
public class EstateHibernateDao implements EstateDAO {

    @Autowired
    private SessionFactory sessionfactory;

    private Log log = LogFactory.getLog(this.getClass());

    @Transactional
    @Override
    public Estate saveEstate(Estate estate) {
        sessionfactory.getCurrentSession().saveOrUpdate(estate);
        log.info("Estate saved successfully");
        return estate;
    }

    @Transactional
    @Override
    public Estate getEstateByName(String name) {
        return (Estate)sessionfactory.getCurrentSession().get(Estate.class,name);
    }

    @Transactional
    @Override
    public Estate getEstateById(Integer id) {
        return (Estate)sessionfactory.getCurrentSession().get(Estate.class,id);
    }

    @Transactional
    @Override
    public List<Estate> getEstateList() {
        Criteria criteria = sessionfactory.getCurrentSession().createCriteria(Estate.class);
        log.info("Got this number of Estates "+ criteria.list().size());
        criteria.addOrder(Order.asc("id"));
        return criteria.list();
    }
}
