package org.restate.project.DAO.hibernate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.restate.project.DAO.AgentDAO;
import org.restate.project.DAO.CountryDAO;
import org.restate.project.model.Agent;
import org.restate.project.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * TODO:please provide a brief description for the class.
 */
public class AgentHibernateDao implements AgentDAO {


    @Autowired
    private SessionFactory sessionfactory;

    private Log log = LogFactory.getLog(this.getClass());

    @Transactional
    @Override
    public Agent saveAgent(Agent agent) {
        sessionfactory.getCurrentSession().saveOrUpdate(agent);
        log.info("Agent saved successfully");
        return agent;
    }

    @Transactional
    @Override
    public Agent getAgent() {
        Criteria criteria = sessionfactory.getCurrentSession().createCriteria(Agent.class);

        return (Agent)criteria.list().get(0);
    }

}
