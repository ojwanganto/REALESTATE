package org.restate.project.controller;

import org.restate.project.model.Country;
import org.restate.project.model.Person;
import org.restate.project.service.CountryService;
import org.restate.project.service.PersonService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("country.form")
public class CountryFormController {
    @Autowired
    private CountryService countryService;

    private static final String LIST_VIEW = "countryList";
    private static final String FORM_VIEW = "countryForm";
    private static final String SUCCESS_VIEW = "redirect:country.list";

    private final Log log = LogFactory.getLog(this.getClass());

    @RequestMapping(method = RequestMethod.GET, value = "country.form")
    public String displayCountryForm(
            @RequestParam(value = "cid", required = false) Integer cid,
            ModelMap modelMap) {

        Country country = null;

        if (cid != null)
            country = countryService.getCountryById(cid);

        if (cid == null) {
            country = new Country();
        }

        modelMap.put("country", country);

        return FORM_VIEW;
    }

    @RequestMapping(method = RequestMethod.POST, value = "country.form")
    public String saveCountry(
            @ModelAttribute("country") Country country,BindingResult bindingResult) {

        countryService.saveCountry(country);

        return SUCCESS_VIEW;
    }


}