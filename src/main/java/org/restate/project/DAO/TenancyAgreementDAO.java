package org.restate.project.DAO;

import org.restate.project.model.Country;
import org.restate.project.model.House;
import org.restate.project.model.TenancyAgreement;
import org.restate.project.model.Tenant;
import org.restate.project.model.Unit;

import java.util.List;

/**
 * TODO:please provide a brief description for the class.
 */
public interface TenancyAgreementDAO {
    public TenancyAgreement saveTenancyAgreement(TenancyAgreement tenancyAgreement);
    public TenancyAgreement getTenancyAgreementByRef(String ref);
    public TenancyAgreement getTenancyAgreementById(Integer id);
    public List<TenancyAgreement> getTenancyAgreementList();
    public List<Unit> getUnitsOfATenantByHouse(Tenant tenant, House house);
}
