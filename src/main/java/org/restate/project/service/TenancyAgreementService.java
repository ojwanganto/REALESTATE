package org.restate.project.service;

import org.restate.project.model.TenancyAgreement;

import java.util.List;

/**
 * service class for Person class
 */
public interface TenancyAgreementService {

    public TenancyAgreement saveTenancyAgreement(TenancyAgreement tenancyAgreement);
    public TenancyAgreement getTenancyAgreementByRef(String ref);
    public TenancyAgreement getTenancyAgreementById(Integer id);
    public List<TenancyAgreement> getTenancyAgreementList();

}
