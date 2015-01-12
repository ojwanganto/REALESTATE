package org.restate.project.service;

import org.restate.project.model.Estate;
import org.restate.project.model.House;
import org.restate.project.model.Tenant;
import org.restate.project.model.Town;
import org.restate.project.model.Unit;

import java.util.List;

/**
 * service class for Unit class
 */
public interface UnitService {

    public Unit saveUnit(Unit unit);
    public Unit getUnitByName(String name);
    public Unit getUnitById(Integer id);
    public List<Unit> getUnitList();
    public List<Unit> getUnitByHouse(House house);


}