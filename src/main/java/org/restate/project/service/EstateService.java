package org.restate.project.service;

import org.restate.project.model.County;
import org.restate.project.model.Estate;
import org.restate.project.model.Town;

import java.util.List;

/**
 * service class for Estate class
 */
public interface EstateService {

    public Estate saveEstate(Estate estate);
    public Estate getEstateByName(String name);
    public Estate getEstateById(Integer id);
    public List<Estate> getEstateList();
    public List<Estate> getEstateByTown(Town town);

}
