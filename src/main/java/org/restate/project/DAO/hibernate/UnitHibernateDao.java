package org.restate.project.DAO.hibernate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.restate.project.DAO.UnitDAO;
import org.restate.project.model.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * TODO:please provide a brief description for the class.
 */
public class UnitHibernateDao implements UnitDAO {

    @Autowired
    private SessionFactory sessionfactory;

    private Log log = LogFactory.getLog(this.getClass());

    @Transactional
    @Override
    public Unit saveUnit(Unit unit) {
        sessionfactory.getCurrentSession().saveOrUpdate(unit);
        log.info("Unit saved successfully");
        return unit;
    }

    @Transactional
    @Override
    public Unit getUnitByName(String name) {
        return (Unit)sessionfactory.getCurrentSession().get(Unit.class,name);
    }

    @Transactional
    @Override
    public List<Unit> getUnitList() {
        Criteria criteria = sessionfactory.getCurrentSession().createCriteria(Unit.class);
        /*log.info("Got this number of Units "+ criteria.list().size());*/
        criteria.addOrder(Order.asc("name"));
        return criteria.list();
    }

    @Transactional
    @Override
    public Unit getUnitById(Integer id) {
        return (Unit)sessionfactory.getCurrentSession().get(Unit.class,id);
    }
}
