package org.restate.project.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.restate.project.model.Country;
import org.restate.project.model.TenancyAgreement;
import org.restate.project.service.CountryService;
import org.restate.project.service.TenancyAgreementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("tenancyAgreement.form")
public class TenancyAgreementFormController {
    @Autowired
    private TenancyAgreementService tenancyAgreementService;

    private static final String LIST_VIEW = "tenancyAgreementList";
    private static final String FORM_VIEW = "tenancyAgreement";
    private static final String SUCCESS_VIEW = "redirect:tenancyAgreement.list";

    private final Log log = LogFactory.getLog(this.getClass());

    @RequestMapping(method = RequestMethod.GET, value = "tenancyAgreement.form")
    public String displayCountryForm(
            @RequestParam(value = "id", required = false) Integer id,
            ModelMap modelMap) {

        TenancyAgreement tenancyAgreement = null;

        if (id != null)
            tenancyAgreement = tenancyAgreementService.getTenancyAgreementById(id);

        if (id == null) {
            tenancyAgreement = new TenancyAgreement();
        }

        modelMap.put("tenancyAgreement", tenancyAgreement);

        return FORM_VIEW;
    }

    @RequestMapping(method = RequestMethod.POST, value = "tenancyAgreement.form")
    public String saveCountry(
            @ModelAttribute("tenancyAgreement") TenancyAgreement tenancyAgreement,BindingResult bindingResult) {

        tenancyAgreementService.saveTenancyAgreement(tenancyAgreement);

        return SUCCESS_VIEW;
    }


}