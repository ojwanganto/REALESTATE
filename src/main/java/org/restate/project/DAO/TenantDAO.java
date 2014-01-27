package org.restate.project.DAO;

import org.restate.project.model.Country;
import org.restate.project.model.Tenant;

import java.util.List;

/**
 * TODO:please provide a brief description for the class.
 */
public interface TenantDAO {
    public Tenant saveTenant(Tenant tenant);
    public Tenant getTenantByCode(String code);
    public Tenant getTenantById(Integer id);
    public List<Tenant> getTenantList();
}
