package org.restate.project.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.restate.project.model.Landlord;
import org.restate.project.service.LandlordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("landlord.list")
public class LandlordListController {
    @Autowired
    private LandlordService landlordService;

    private static final String LIST_VIEW = "landlordList";

    private final Log log = LogFactory.getLog(this.getClass());

	@RequestMapping(method = RequestMethod.GET)
	public String printLandlordList(ModelMap model) {

        List<Landlord> landlords = landlordService.getLandlordList();

		model.addAttribute("landlords", landlords);
		return LIST_VIEW;
	}





}