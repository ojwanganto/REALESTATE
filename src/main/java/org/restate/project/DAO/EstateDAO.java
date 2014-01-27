package org.restate.project.DAO;

import org.restate.project.model.Country;
import org.restate.project.model.Estate;

import java.util.List;

/**
 * TODO:please provide a brief description for the class.
 */
public interface EstateDAO {
    public Estate saveEstate(Estate estate);
    public Estate getEstateByName(String name);
    public Estate getEstateById(Integer id);
    public List<Estate> getEstateList();
}
