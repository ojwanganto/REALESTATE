package org.restate.project.service.impl;

import org.restate.project.DAO.LandlordDAO;
import org.restate.project.model.Landlord;
import org.restate.project.service.LandlordService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * implementation class for CountryService class
 */
public class LandlordServiceImpl implements LandlordService {

    @Autowired
    private LandlordDAO landlordDAO;


    @Override
    public Landlord saveLandlord(Landlord landlord) {
        return landlordDAO.saveLandlord(landlord);
    }

    @Override
    public Landlord getLandlordById(Integer id) {
        return landlordDAO.getLandlordById(id);
    }

    @Override
    public List<Landlord> getLandlordList() {
        return landlordDAO.getLandlordList();
    }
}
