package org.restate.project.service;

import org.restate.project.model.Tenant;

import java.util.List;

/**
 * service class for Person class
 */
public interface TenantService {

    public Tenant saveTenant(Tenant tenant);
    public Tenant getTenantByName(String name);
    public Tenant getTenantById(Integer id);
    public List<Tenant> getTenantList();

}
