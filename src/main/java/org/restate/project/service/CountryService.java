package org.restate.project.service;

import org.restate.project.model.Country;

import java.util.List;

/**
 * service class for Person class
 */
public interface CountryService {

    public Country saveCountry(Country country);
    public Country getCountryByCode(String code);
    public Country getCountryById(Integer id);
    public List<Country> getCountryList();

}
