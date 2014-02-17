package org.restate.project.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.restate.project.model.LandlordAgreement;
import org.restate.project.model.TenancyAgreement;
import org.restate.project.service.LandlordAgreementService;
import org.restate.project.service.TenancyAgreementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("landlordAgreement.list")
public class LandlordAgreementListController {
    @Autowired
    private LandlordAgreementService landlordAgreementService;

    private static final String LIST_VIEW = "landlordAgreementList";

    private final Log log = LogFactory.getLog(this.getClass());

	@RequestMapping(method = RequestMethod.GET)
	public String printPersonList(ModelMap model) {

        List<LandlordAgreement> landlordAgreements = landlordAgreementService.getLandlordAgreementList();

		model.addAttribute("landlordAgreements", landlordAgreements);
		return LIST_VIEW;
	}





}