package org.restate.project.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.restate.project.model.Country;
import org.restate.project.model.Person;
import org.restate.project.service.CountryService;
import org.restate.project.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("country.list")
public class CountryListController {
    @Autowired
    private CountryService countryService;

    private static final String LIST_VIEW = "countryList";

    private final Log log = LogFactory.getLog(CountryListController.class);

	@RequestMapping(method = RequestMethod.GET)
	public String printPersonList(ModelMap model) {

        List<Country> countries = countryService.getCountryList();

		model.addAttribute("countries", countries);
		return LIST_VIEW;
	}





}