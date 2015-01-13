package org.restate.project.service;

import org.restate.project.model.Estate;
import org.restate.project.model.House;

import java.util.List;

/**
 * service class for Person class
 */
public interface HouseService {

    public House saveHouse(House house);
    public House getHouseByName(String name);
    public House getHouseById(Integer id);
    public List<House> getHouseList();
    public List<House> getHousesByEstate(Estate estate);

}
