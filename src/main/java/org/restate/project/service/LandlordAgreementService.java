package org.restate.project.service;

import org.restate.project.model.LandlordAgreement;

import java.util.List;

/**
 * service class for Landlord Agreement
 */
public interface LandlordAgreementService {

    public LandlordAgreement saveLandlordAgreement(LandlordAgreement landlordAgreement);
    public LandlordAgreement getLandlordAgreementByRef(String ref);
    public LandlordAgreement getLandlordAgreementById(Integer id);
    public List<LandlordAgreement> getLandlordAgreementList();

}
