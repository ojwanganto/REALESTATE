package org.restate.project.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.restate.project.model.House;
import org.restate.project.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("house.list")
public class HouseListController {
    @Autowired
    private HouseService houseService;

    private static final String LIST_VIEW = "houseList";

    private final Log log = LogFactory.getLog(this.getClass());

	@RequestMapping(method = RequestMethod.GET)
	public String printPersonList(ModelMap model) {

        List<House> houses = houseService.getHouseList();

		model.addAttribute("houses", houses);
		return LIST_VIEW;
	}





}