package org.restate.project.DAO.hibernate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.restate.project.DAO.CountryDAO;
import org.restate.project.DAO.TenantDAO;
import org.restate.project.model.Country;
import org.restate.project.model.Tenant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * TODO:please provide a brief description for the class.
 */
public class TenantHibernateDao implements TenantDAO {

    @Autowired
    private SessionFactory sessionfactory;

    private Log log = LogFactory.getLog(this.getClass());

    @Transactional
    @Override
    public Tenant saveTenant(Tenant tenant) {
        sessionfactory.getCurrentSession().saveOrUpdate(tenant);
        log.info("Tenant saved successfully");
        return tenant;
    }

    @Transactional
    @Override
    public Tenant getTenantByCode(String code) {
        return (Tenant)sessionfactory.getCurrentSession().get(Tenant.class,code);
    }

    @Transactional
    @Override
    public Tenant getTenantById(Integer id) {
        return (Tenant)sessionfactory.getCurrentSession().get(Tenant.class,id);
    }

    @Transactional
    @Override
    public List<Tenant> getTenantList() {
        Criteria criteria = sessionfactory.getCurrentSession().createCriteria(Tenant.class);
        log.info("Got this number of Tenants "+ criteria.list().size());
        criteria.addOrder(Order.asc("id"));
        return criteria.list();
    }
}
