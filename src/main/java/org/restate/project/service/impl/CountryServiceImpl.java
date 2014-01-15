package org.restate.project.service.impl;

import org.restate.project.DAO.CountryDAO;
import org.restate.project.model.Country;
import org.restate.project.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * implementation class for CountryService class
 */
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryDAO countryDAO;

    @Override
    public Country saveCountry(Country country) {
        return countryDAO.saveCountry(country);
    }

    @Override
    public Country getCountryByCode(String code) {
        return countryDAO.getCountryByCode(code);
    }

    @Override
    public Country getCountryById(Integer id) {
        return countryDAO.getCountryById(id);
    }

    @Override
    public List<Country> getCountryList() {
        return countryDAO.getCountryList();
    }
}
