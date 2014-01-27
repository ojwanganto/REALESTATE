package org.restate.project.service;

import org.restate.project.model.County;

import java.util.List;

/**
 * service class for Person class
 */
public interface CountyService {

    public County saveCounty(County county);
    public County getCountyByCode(String code);
    public County getCountyById(Integer id);
    public List<County> getCountyList();

}
