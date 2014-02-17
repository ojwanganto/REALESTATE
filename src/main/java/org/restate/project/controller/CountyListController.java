package org.restate.project.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.restate.project.model.County;
import org.restate.project.service.CountyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("county.list")
public class CountyListController {
    @Autowired
    private CountyService countyService;

    private static final String LIST_VIEW = "countyList";

    private final Log log = LogFactory.getLog(this.getClass());

	@RequestMapping(method = RequestMethod.GET)
	public String printPersonList(ModelMap model) {

        List<County> counties = countyService.getCountyList();

		model.addAttribute("counties", counties);
		return LIST_VIEW;
	}





}