package org.restate.project.DAO;

import org.restate.project.model.Country;
import org.restate.project.model.Town;

import java.util.List;

/**
 * TODO:please provide a brief description for the class.
 */
public interface TownDAO {
    public Town saveTown(Town town);
    public Town getTownByName(String name);
    public Town getTownById(Integer id);
    public List<Town> getTownList();
}
