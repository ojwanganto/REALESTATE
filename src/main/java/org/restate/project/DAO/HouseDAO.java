package org.restate.project.DAO;

import org.restate.project.model.Country;
import org.restate.project.model.House;

import java.util.List;

/**
 * TODO:please provide a brief description for the class.
 */
public interface HouseDAO {
    public House saveHouse(House house);
    public House getHouseByName(String name);
    public House getHouseById(Integer id);
    public List<House> getHouseList();
}
