package org.restate.project.service.impl;

import org.restate.project.DAO.TenantDAO;
import org.restate.project.model.Tenant;
import org.restate.project.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * implementation class for TenantService class
 */
public class TenantServiceImpl implements TenantService {

    @Autowired
    private TenantDAO tenantDAO;

    @Override
    public Tenant saveTenant(Tenant tenant) {
        return tenantDAO.saveTenant(tenant);
    }

    @Override
    public Tenant getTenantByName(String name) {
        return tenantDAO.getTenantByCode(name);
    }

    @Override
    public Tenant getTenantById(Integer id) {
        return tenantDAO.getTenantById(id);
    }

    @Override
    public List<Tenant> getTenantList() {
        return tenantDAO.getTenantList();
    }
}
