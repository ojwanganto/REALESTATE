package org.restate.project.service.impl;

import org.restate.project.DAO.TownDAO;
import org.restate.project.model.Town;
import org.restate.project.service.TownService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * implementation class for CountryService class
 */
public class TownServiceImpl implements TownService {

    @Autowired
    private TownDAO townDAO;


    @Override
    public Town saveTown(Town town) {
        return townDAO.saveTown(town);
    }

    @Override
    public Town getTownByName(String name) {
        return townDAO.getTownByName(name);
    }

    @Override
    public Town getTownById(Integer id) {
        return townDAO.getTownById(id);
    }

    @Override
    public List<Town> getTownList() {
        return townDAO.getTownList();
    }
}
