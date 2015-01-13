package org.restate.project.service.impl;

import org.restate.project.DAO.CountryDAO;
import org.restate.project.DAO.TenancyAgreementDAO;
import org.restate.project.model.Country;
import org.restate.project.model.House;
import org.restate.project.model.TenancyAgreement;
import org.restate.project.model.Tenant;
import org.restate.project.model.Unit;
import org.restate.project.service.CountryService;
import org.restate.project.service.TenancyAgreementService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * implementation class for CountryService class
 */
public class TenancyAgreementServiceImpl implements TenancyAgreementService {

    @Autowired
    private TenancyAgreementDAO tenancyAgreementDAO;


    @Override
    public TenancyAgreement saveTenancyAgreement(TenancyAgreement tenancyAgreement) {
        return tenancyAgreementDAO.saveTenancyAgreement(tenancyAgreement);
    }

    @Override
    public TenancyAgreement getTenancyAgreementByRef(String ref) {
        return tenancyAgreementDAO.getTenancyAgreementByRef(ref);
    }

    @Override
    public TenancyAgreement getTenancyAgreementById(Integer id) {
        return tenancyAgreementDAO.getTenancyAgreementById(id);
    }

    @Override
    public List<TenancyAgreement> getTenancyAgreementList() {
        return tenancyAgreementDAO.getTenancyAgreementList();
    }

    @Override
    public List<Unit> getUnitsOfATenantByHouse(Tenant tenant, House house) {
        return tenancyAgreementDAO.getUnitsOfATenantByHouse(tenant,house);
    }
}
