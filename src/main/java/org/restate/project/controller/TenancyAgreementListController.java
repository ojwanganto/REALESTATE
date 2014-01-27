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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("tenancyAgreement.list")
public class TenancyAgreementListController {
    @Autowired
    private TenancyAgreementService tenancyAgreementService;

    private static final String LIST_VIEW = "tenancyAgreementList";

    private final Log log = LogFactory.getLog(this.getClass());

	@RequestMapping(method = RequestMethod.GET)
	public String printPersonList(ModelMap model) {

        List<TenancyAgreement> tenancyAgreements = tenancyAgreementService.getTenancyAgreementList();

		model.addAttribute("tenancyAgreements", tenancyAgreements);
		return LIST_VIEW;
	}





}