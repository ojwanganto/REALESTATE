package org.restate.project.DAO.hibernate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.restate.project.DAO.TownDAO;
import org.restate.project.model.Town;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * TODO:please provide a brief description for the class.
 */
public class TownHibernateDao implements TownDAO {

    @Autowired
    private SessionFactory sessionfactory;

    private Log log = LogFactory.getLog(this.getClass());

    @Transactional
    @Override
    public Town saveTown(Town town) {
        sessionfactory.getCurrentSession().saveOrUpdate(town);
        log.info("Town saved successfully");
        return town;
    }

    @Transactional
    @Override
    public Town getTownByName(String name) {
        return (Town)sessionfactory.getCurrentSession().get(Town.class,name);
    }

    @Transactional
    @Override
    public List<Town> getTownList() {
        Criteria criteria = sessionfactory.getCurrentSession().createCriteria(Town.class);
        /*log.info("Got this number of Towns "+ criteria.list().size());*/
        criteria.addOrder(Order.asc("id"));
        return criteria.list();
    }

    @Transactional
    @Override
    public Town getTownById(Integer id) {
        return (Town)sessionfactory.getCurrentSession().get(Town.class,id);
    }
}
