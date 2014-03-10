package org.restate.project.DAO.hibernate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.restate.project.DAO.LandlordDAO;
import org.restate.project.model.Landlord;
import org.restate.project.model.Person;
import org.restate.project.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * TODO:please provide a brief description for the class.
 */
public class LandlordHibernateDao implements LandlordDAO {

    @Autowired
    private SessionFactory sessionfactory;

    @Autowired
    private PersonService personService;

    private Log log = LogFactory.getLog(this.getClass());


    @Transactional
    @Override
    public Landlord saveLandlord(Landlord landlord) {

        Person person = new Person();
        person.setDateCreated(new Date());
        person.setFirstName(landlord.getFirstName());
        person.setMiddleName(landlord.getMiddleName());
        person.setLastName(landlord.getLastName());
        Person savedP = personService.savePerson(person);
        landlord.setPersonId(savedP);
        landlord.setDateCreated(new Date());
        sessionfactory.getCurrentSession().saveOrUpdate(landlord);
        return landlord;
    }

    @Transactional
    @Override
    public Landlord getLandlordById(Integer id) {
        return  (Landlord)sessionfactory.getCurrentSession().get(Landlord.class,id);
    }

    @Transactional
    @Override
    public List<Landlord> getLandlordList() {
        Criteria criteria = sessionfactory.getCurrentSession().createCriteria(Landlord.class);
        criteria.addOrder(Order.asc("id"));
        return criteria.list();
    }
}
