package org.restate.project.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.restate.project.model.House;
import org.restate.project.model.Unit;
import org.restate.project.service.HouseService;
import org.restate.project.service.UnitService;
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
@RequestMapping("unit.form")
public class UnitFormController {
    @Autowired
    private UnitService unitService;

    @Autowired
    private HouseService houseService;

    private static final String LIST_VIEW = "unitList";
    private static final String FORM_VIEW = "unitForm";
    private static final String SUCCESS_VIEW = "redirect:unit.list";

    private final Log log = LogFactory.getLog(this.getClass());

    @ModelAttribute("houses")
    public List<House> getHouses() {
        return houseService.getHouseList();
    }

    @RequestMapping(method = RequestMethod.GET, value = "unit.form")
    public String displayCountryForm(
            @RequestParam(value = "id", required = false) Integer id,
            ModelMap modelMap) {

        Unit unit = null;

        if (id != null)
            unit = unitService.getUnitById(id);

        if (id == null) {
            unit = new Unit();
        }

        modelMap.put("unit", unit);

        return FORM_VIEW;
    }

    @RequestMapping(method = RequestMethod.POST, value = "unit.form")
    public String saveCountry(
            @ModelAttribute("unit") Unit unit,BindingResult bindingResult) {

        unitService.saveUnit(unit);

        return SUCCESS_VIEW;
    }


}