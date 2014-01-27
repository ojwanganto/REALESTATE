package org.restate.project.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.restate.project.model.Country;
import org.restate.project.model.Tenant;
import org.restate.project.service.CountryService;
import org.restate.project.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("tenant.list")
public class TenantListController {
    @Autowired
    private TenantService tenantService;

    private static final String LIST_VIEW = "tenantList";

    private final Log log = LogFactory.getLog(this.getClass());

	@RequestMapping(method = RequestMethod.GET)
	public String printPersonList(ModelMap model) {

        List<Tenant> tenants = tenantService.getTenantList();

		model.addAttribute("tenants", tenants);
		return LIST_VIEW;
	}





}