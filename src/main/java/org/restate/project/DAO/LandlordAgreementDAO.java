package org.restate.project.DAO;

import org.restate.project.model.LandlordAgreement;

import java.util.List;

/**
 * TODO:please provide a brief description for the class.
 */
public interface LandlordAgreementDAO {
    public LandlordAgreement saveLandlordAgreement(LandlordAgreement landlordAgreement);
    public LandlordAgreement getLandlordAgreementByRef(String ref);
    public LandlordAgreement getLandlordAgreementById(Integer id);
    public List<LandlordAgreement> getLandlordAgreementList();
}
