package org.restate.project.service.impl;

import org.restate.project.DAO.CountryDAO;
import org.restate.project.DAO.HouseDAO;
import org.restate.project.model.Country;
import org.restate.project.model.House;
import org.restate.project.service.CountryService;
import org.restate.project.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * implementation class for CountryService class
 */
public class HouseServiceImpl implements HouseService {

    @Autowired
    private HouseDAO houseDAO;

    @Override
    public House saveHouse(House house) {
        return houseDAO.saveHouse(house);
    }

    @Override
    public House getHouseByName(String name) {
        return houseDAO.getHouseByName(name);
    }

    @Override
    public House getHouseById(Integer id) {
        return houseDAO.getHouseById(id);
    }

    @Override
    public List<House> getHouseList() {
        return houseDAO.getHouseList();
    }
}
