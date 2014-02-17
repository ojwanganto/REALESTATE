package org.restate.project.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.restate.project.model.Country;
import org.restate.project.model.Landlord;
import org.restate.project.service.CountryService;
import org.restate.project.service.LandlordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("landlord.form")
public class LandlordFormController {
    @Autowired
    private LandlordService landlordService;

    @Autowired
    private CountryService countryService;
    private static final String LIST_VIEW = "landlordList";
    private static final String FORM_VIEW = "landlordForm";
    private static final String SUCCESS_VIEW = "redirect:landlord.list";

    private final Log log = LogFactory.getLog(this.getClass());

    @ModelAttribute("countries")
    public List<Country> getCountries() {
        return countryService.getCountryList();
    }


    @RequestMapping(method = RequestMethod.GET, value = "landlord.form")
    public String displayLandlordForm(
            @RequestParam(value = "id", required = false) Integer id,
            ModelMap modelMap) {

        Landlord landlord = null;

        if (id != null)
            landlord = landlordService.getLandlordById(id);

        if (id == null) {
            landlord = new Landlord();
        }

        modelMap.put("landlord", landlord);

        return FORM_VIEW;
    }

    @RequestMapping(method = RequestMethod.POST, value = "landlord.form")
    public String saveLandlord(
            @ModelAttribute("landlord") Landlord landlord,BindingResult bindingResult) {

        landlordService.saveLandlord(landlord);

        return SUCCESS_VIEW;
    }

    private void dateBinder(WebDataBinder binder) {
        // The date format to parse or output your dates
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

        // Register them as custom editors for the Date type
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

}