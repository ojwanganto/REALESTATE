package org.restate.project.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.restate.project.model.Country;
import org.restate.project.model.County;
import org.restate.project.service.CountryService;
import org.restate.project.service.CountyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("county.form")
public class CountyFormController {
    @Autowired
    private CountyService countyService;

    private static final String LIST_VIEW = "countyList";
    private static final String FORM_VIEW = "countyForm";
    private static final String SUCCESS_VIEW = "redirect:county.list";

    private final Log log = LogFactory.getLog(this.getClass());

    @RequestMapping(method = RequestMethod.GET, value = "county.form")
    public String displayCountryForm(
            @RequestParam(value = "id", required = false) Integer id,
            ModelMap modelMap) {

        County county = null;

        if (id != null)
            county = countyService.getCountyById(id);

        if (id == null) {
            county = new County();
        }

        modelMap.put("county", county);

        return FORM_VIEW;
    }

    @RequestMapping(method = RequestMethod.POST, value = "county.form")
    public String saveCounty(
            @ModelAttribute("county") County county,BindingResult bindingResult) {

        countyService.saveCounty(county);

        return SUCCESS_VIEW;
    }


}