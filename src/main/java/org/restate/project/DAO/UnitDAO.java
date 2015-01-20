package org.restate.project.DAO;

import org.restate.project.model.Country;
import org.restate.project.model.House;
import org.restate.project.model.Tenant;
import org.restate.project.model.Unit;

import java.util.List;

/**
 * TODO:please provide a brief description for the class.
 */
public interface UnitDAO {
    public Unit saveUnit(Unit unit);
    public Unit getUnitByName(String name);
    public Unit getUnitById(Integer id);
    public List<Unit> getUnitList();
    public List<Unit> getUnitByHouse(House house);
}
