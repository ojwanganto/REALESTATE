package org.restate.project.service.impl;

import org.restate.project.DAO.CountryDAO;
import org.restate.project.DAO.CountyDAO;
import org.restate.project.model.Country;
import org.restate.project.model.County;
import org.restate.project.service.CountryService;
import org.restate.project.service.CountyService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * implementation class for CountryService class
 */
public class CountyServiceImpl implements CountyService {

    @Autowired
    private CountyDAO countyDAO;

    @Override
    public County saveCounty(County county) {
        return countyDAO.saveCounty(county);
    }

    @Override
    public County getCountyByCode(String code) {
        return countyDAO.getCountyByCode(code);
    }

    @Override
    public County getCountyById(Integer id) {
        return countyDAO.getCountyById(id);
    }

    @Override
    public List<County> getCountyList() {
        return countyDAO.getCountyList();
    }
}
