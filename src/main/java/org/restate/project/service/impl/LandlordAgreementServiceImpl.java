package org.restate.project.service.impl;

import org.restate.project.DAO.LandlordAgreementDAO;
import org.restate.project.model.LandlordAgreement;
import org.restate.project.service.LandlordAgreementService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * implementation class for CountryService class
 */
public class LandlordAgreementServiceImpl implements LandlordAgreementService {

    @Autowired
    private LandlordAgreementDAO landlordAgreementDAO;


    @Override
    public LandlordAgreement saveLandlordAgreement(LandlordAgreement landlordAgreement) {
        return landlordAgreementDAO.saveLandlordAgreement(landlordAgreement);
    }

    @Override
    public LandlordAgreement getLandlordAgreementByRef(String ref) {
        return landlordAgreementDAO.getLandlordAgreementByRef(ref);
    }

    @Override
    public LandlordAgreement getLandlordAgreementById(Integer id) {
        return landlordAgreementDAO.getLandlordAgreementById(id);
    }

    @Override
    public List<LandlordAgreement> getLandlordAgreementList() {
        return landlordAgreementDAO.getLandlordAgreementList();
    }
}
