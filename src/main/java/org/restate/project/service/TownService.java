package org.restate.project.service;

import org.restate.project.model.Town;

import java.util.List;

/**
 * service class for Person class
 */
public interface TownService {

    public Town saveTown(Town town);
    public Town getTownByName(String name);
    public Town getTownById(Integer id);
    public List<Town> getTownList();

}
