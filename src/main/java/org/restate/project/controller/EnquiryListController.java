package org.restate.project.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.restate.project.model.Country;
import org.restate.project.model.Enquiry;
import org.restate.project.service.CountryService;
import org.restate.project.service.EnquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("enquiry.list")
public class EnquiryListController {
    @Autowired
    private EnquiryService enquiryService;

    private static final String LIST_VIEW = "enquiryList";

    private final Log log = LogFactory.getLog(this.getClass());

	@RequestMapping(method = RequestMethod.GET)
	public String printEnquiryList(ModelMap model) {

        List<Enquiry> enquiries = enquiryService.getEnquiryList();

		model.addAttribute("enquiries", enquiries);
		return LIST_VIEW;
	}





}