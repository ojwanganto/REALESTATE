package org.restate.project.service;

import org.restate.project.model.House;
import org.restate.project.model.TenancyAgreement;
import org.restate.project.model.Tenant;
import org.restate.project.model.Unit;

import java.util.List;

/**
 * service class for Person class
 */
public interface TenancyAgreementService {

    public TenancyAgreement saveTenancyAgreement(TenancyAgreement tenancyAgreement);
    public TenancyAgreement getTenancyAgreementByRef(String ref);
    public TenancyAgreement getTenancyAgreementById(Integer id);
    public List<TenancyAgreement> getTenancyAgreementList();
    public List<Unit> getUnitsOfATenantByHouse(Tenant tenant, House house);

}
