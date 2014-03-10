package org.restate.project.DAO.hibernate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.restate.project.DAO.PersonDAO;
import org.restate.project.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * implementation class for Person dao
 */
@Repository
public class PersonHibernateDaoImpl implements PersonDAO {

    @Autowired
    private SessionFactory sessionfactory;

    private Log log = LogFactory.getLog(this.getClass());

    @Transactional
    @Override
    public Person savePerson(Person person) {
        sessionfactory.getCurrentSession().saveOrUpdate(person);
        log.info("Person saved successfully");
        return person;
    }

    @Transactional
    @Override
    public Person getPersonById(Integer pid) {
        return (Person)sessionfactory.getCurrentSession().get(Person.class,pid);
    }

    @Transactional
    @Override
    public List<Person> getPersonsList() {
        Criteria criteria = sessionfactory.getCurrentSession().createCriteria(Person.class);
        criteria.addOrder(Order.asc("name"));
        return criteria.list();
    }
}
