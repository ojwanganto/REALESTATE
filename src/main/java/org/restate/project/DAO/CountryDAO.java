package org.restate.project.DAO;

import org.restate.project.model.Country;

import java.util.List;

/**
 * TODO:please provide a brief description for the class.
 */
public interface CountryDAO {
    public Country saveCountry(Country country);
    public Country getCountryByCode(String code);
    public List<Country> getCountryList();

    public Country getCountryById(Integer id);
}
