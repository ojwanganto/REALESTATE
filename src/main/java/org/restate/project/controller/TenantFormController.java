package org.restate.project.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.restate.project.model.Country;
import org.restate.project.model.Tenant;
import org.restate.project.service.CountryService;
import org.restate.project.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("tenant.form")
public class TenantFormController {
    @Autowired
    private TenantService tenantService;

    @Autowired
    private CountryService countryService;
    private static final String LIST_VIEW = "tenantList";
    private static final String FORM_VIEW = "tenantForm";
    private static final String SUCCESS_VIEW = "redirect:tenant.list";

    private final Log log = LogFactory.getLog(this.getClass());

    @ModelAttribute("countries")
    public List<Country> getCountries() {
        return countryService.getCountryList();
    }

    @RequestMapping(method = RequestMethod.GET, value = "tenant.form")
    public String displayCountryForm(
            @RequestParam(value = "id", required = false) Integer id,
            ModelMap modelMap) {

        Tenant tenant = null;

        if (id != null)
            tenant = tenantService.getTenantById(id);

        if (id == null) {
            tenant = new Tenant();
        }

        modelMap.put("tenant", tenant);

        return FORM_VIEW;
    }

    @RequestMapping(method = RequestMethod.POST, value = "tenant.form")
    public String saveCountry(
            @ModelAttribute("tenant") Tenant tenant,BindingResult bindingResult) {

        tenantService.saveTenant(tenant);

        return SUCCESS_VIEW;
    }

    private void dateBinder(WebDataBinder binder) {
        // The date format to parse or output your dates
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

        // Register them as custom editors for the Date type
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

}