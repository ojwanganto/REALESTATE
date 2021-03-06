package org.restate.project.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.restate.project.model.Estate;
import org.restate.project.model.House;
import org.restate.project.model.Landlord;
import org.restate.project.service.EstateService;
import org.restate.project.service.HouseService;
import org.restate.project.service.LandlordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("house.form")
public class HouseFormController {
    @Autowired
    private HouseService houseService;

    @Autowired
    private EstateService estateService;

    @Autowired
    private LandlordService landlordService;

    private static final String LIST_VIEW = "houseList";
    private static final String FORM_VIEW = "houseForm";
    private static final String SUCCESS_VIEW = "redirect:house.list";

    private final Log log = LogFactory.getLog(this.getClass());

    @ModelAttribute("landlords")
    public List<Landlord> getLandlords() {
        return landlordService.getLandlordList();
    }

    @ModelAttribute("estates")
    public List<Estate> getEstates() {
        return estateService.getEstateList();
    }


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