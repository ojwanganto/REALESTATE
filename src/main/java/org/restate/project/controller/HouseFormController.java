package org.restate.project.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.restate.project.model.Country;
import org.restate.project.model.House;
import org.restate.project.service.CountryService;
import org.restate.project.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("house.form")
public class HouseFormController {
    @Autowired
    private HouseService houseService;

    private static final String LIST_VIEW = "houseList";
    private static final String FORM_VIEW = "houseForm";
    private static final String SUCCESS_VIEW = "redirect:house.list";

    private final Log log = LogFactory.getLog(this.getClass());

    @RequestMapping(method = RequestMethod.GET, value = "house.form")
    public String displayCountryForm(
            @RequestParam(value = "id", required = false) Integer id,
            ModelMap modelMap) {

        House house = null;

        if (id != null)
            house = houseService.getHouseById(id);

        if (id == null) {
            house = new House();
        }

        modelMap.put("house", house);

        return FORM_VIEW;
    }

    @RequestMapping(method = RequestMethod.POST, value = "house.form")
    public String saveCountry(
            @ModelAttribute("house") House house,BindingResult bindingResult) {

        houseService.saveHouse(house);

        return SUCCESS_VIEW;
    }


}