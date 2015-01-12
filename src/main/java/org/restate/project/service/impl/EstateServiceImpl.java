package org.restate.project.service.impl;

import org.restate.project.DAO.EstateDAO;
import org.restate.project.model.Estate;
import org.restate.project.model.Town;
import org.restate.project.service.EstateService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * implementation class for CountryService class
 */
public class EstateServiceImpl implements EstateService {

    @Autowired
    private EstateDAO estateDAO;


    @Override
    public Estate saveEstate(Estate estate) {
        return estateDAO.saveEstate(estate);
    }

    @Override
    public Estate getEstateByName(String name) {
        return estateDAO.getEstateByName(name);
    }

    @Override
    public Estate getEstateById(Integer id) {
        return estateDAO.getEstateById(id);
    }

    @Override
    public List<Estate> getEstateList() {
        return estateDAO.getEstateList();
    }

    @Override
    public List<Estate> getEstateByTown(Town town) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
