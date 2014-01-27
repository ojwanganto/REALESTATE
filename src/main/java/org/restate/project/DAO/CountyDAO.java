package org.restate.project.DAO;

import org.restate.project.model.Country;
import org.restate.project.model.County;

import java.util.List;

/**
 * TODO:please provide a brief description for the class.
 */
public interface CountyDAO {
    public County saveCounty(County county);
    public County getCountyByCode(String code);
    public County getCountyById(Integer id);
    public List<County> getCountyList();
}
