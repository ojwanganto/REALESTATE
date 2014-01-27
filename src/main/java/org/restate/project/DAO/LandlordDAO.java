package org.restate.project.DAO;

import org.restate.project.model.Country;
import org.restate.project.model.Landlord;

import java.util.List;

/**
 * TODO:please provide a brief description for the class.
 */
public interface LandlordDAO {
    public Landlord saveLandlord(Landlord landlord);
    public Landlord getLandlordById(Integer id);
    public List<Landlord> getLandlordList();
}
