package org.restate.project.DAO.hibernate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.restate.project.DAO.EstateDAO;
import org.restate.project.model.County;
import org.restate.project.model.Estate;
import org.restate.project.model.Town;
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
        criteria.addOrder(Order.asc("id"));
        return criteria.list();
    }

    @Override
    public List<Estate> getEstateByTown(Town town) {
        Criteria c = sessionfactory.getCurrentSession().createCriteria(Estate.class)
                .add(Restrictions.eq("town", town));
                //.setProjection(Projections.property("facility"));

        return c.list();
    }
    /*Criteria c = sessionFactory.getCurrentSession().createCriteria(UserFacility.class)
            .add(Restrictions.eq("user", user))
            .setProjection(Projections.property("facility"));

    return c.list();*/
}
