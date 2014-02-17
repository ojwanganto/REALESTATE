package org.restate.project.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.restate.project.model.Estate;
import org.restate.project.service.EstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("estate.list")
public class EstateListController {
    @Autowired
    private EstateService estateService;

    private static final String LIST_VIEW = "estateList";

    private final Log log = LogFactory.getLog(this.getClass());

	@RequestMapping(method = RequestMethod.GET)
	public String printPersonList(ModelMap model) {

        List<Estate> estates = estateService.getEstateList();

		model.addAttribute("estates", estates);
		return LIST_VIEW;
	}





}