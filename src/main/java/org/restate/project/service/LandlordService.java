package org.restate.project.service;

import org.restate.project.model.Landlord;

import java.util.List;

/**
 * service class for Person class
 */
public interface LandlordService {

    public Landlord saveLandlord(Landlord landlord);
    public Landlord getLandlordById(Integer id);
    public List<Landlord> getLandlordList();

}
