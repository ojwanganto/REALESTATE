package org.restate.project.DAO.hibernate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.restate.project.DAO.UnitDAO;
import org.restate.project.model.House;
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
        criteria.addOrder(Order.asc("name"));
        return criteria.list();
    }

    @Transactional
    @Override
    public List<Unit> getUnitByHouse(House house) {
        Criteria c = sessionfactory.getCurrentSession().createCriteria(Unit.class)
                .add(Restrictions.eq("house", house));
        return c.list();
    }

	@Transactional
	@Override
	public List<Unit> getVacantUnitByHouse(House house) {
		Criteria c = sessionfactory.getCurrentSession().createCriteria(Unit.class)
				.add(Restrictions.eq("house", house))
				.add(Restrictions.eq("occupied", false));

		return c.list();
	}

	@Transactional
	@Override
	public List<Unit> getVacantUnits() {
		Criteria criteria = sessionfactory.getCurrentSession().createCriteria(Unit.class);
		criteria.add(Restrictions.eq("occupied", false));
		criteria.addOrder(Order.asc("name"));
		return criteria.list();
	}

	@Transactional
    @Override
    public Unit getUnitById(Integer id) {
        return (Unit)sessionfactory.getCurrentSession().get(Unit.class,id);
    }
}
