package org.restate.project.DAO.hibernate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.restate.project.DAO.HouseDAO;
import org.restate.project.model.House;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * TODO:please provide a brief description for the class.
 */
public class HouseHibernateDao implements HouseDAO {

    @Autowired
    private SessionFactory sessionfactory;

    private Log log = LogFactory.getLog(this.getClass());

    @Transactional
    @Override
    public House saveHouse(House House) {
        sessionfactory.getCurrentSession().saveOrUpdate(House);
        log.info("House saved successfully");
        return House;
    }

    @Transactional
    @Override
    public House getHouseByName(String name) {
        return (House)sessionfactory.getCurrentSession().get(House.class,name);
    }

    @Transactional
    @Override
    public List<House> getHouseList() {
        Criteria criteria = sessionfactory.getCurrentSession().createCriteria(House.class);
        log.info("Got this number of Houses "+ criteria.list().size());
        criteria.addOrder(Order.asc("id"));
        return criteria.list();
    }

    @Transactional
    @Override
    public House getHouseById(Integer id) {
        return (House)sessionfactory.getCurrentSession().get(House.class,id);
    }
}
