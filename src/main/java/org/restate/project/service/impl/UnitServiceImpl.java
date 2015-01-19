package org.restate.project.service.impl;

import org.restate.project.DAO.UnitDAO;
import org.restate.project.model.House;
import org.restate.project.model.Unit;
import org.restate.project.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * implementation class for CountryService class
 */
public class UnitServiceImpl implements UnitService {

    @Autowired
    private UnitDAO unitDAO;

    @Override
    public Unit saveUnit(Unit unit) {
        return unitDAO.saveUnit(unit);
    }

    @Override
    public Unit getUnitByName(String name) {
        return unitDAO.getUnitByName(name);
    }

    @Override
    public Unit getUnitById(Integer id) {
        return unitDAO.getUnitById(id);
    }

    @Override
    public List<Unit> getUnitList() {
        return unitDAO.getUnitList();
    }

    @Override
    public List<Unit> getUnitByHouse(House house) {
        return unitDAO.getUnitByHouse(house);
    }

	@Override
	public List<Unit> getVacantUnitByHouse(House house) {
		return unitDAO.getVacantUnitByHouse(house);
	}

	@Override
	public List<Unit> getVacantUnits() {
		return unitDAO.getVacantUnits();
	}

}
