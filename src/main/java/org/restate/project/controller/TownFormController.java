package org.restate.project.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.restate.project.model.Country;
import org.restate.project.model.Town;
import org.restate.project.service.CountryService;
import org.restate.project.service.TownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("town.form")
public class TownFormController {
    @Autowired
    private TownService townService;

    private static final String LIST_VIEW = "townList";
    private static final String FORM_VIEW = "townForm";
    private static final String SUCCESS_VIEW = "redirect:town.list";

    private final Log log = LogFactory.getLog(this.getClass());

    @RequestMapping(method = RequestMethod.GET, value = "town.form")
    public String townForm(
            @RequestParam(value = "id", required = false) Integer id,
            ModelMap modelMap) {

        Town town = null;

        if (id != null)
            town = townService.getTownById(id);

        if (id == null) {
            town = new Town();
        }

        modelMap.put("town", town);

        return FORM_VIEW;
    }

    @RequestMapping(method = RequestMethod.POST, value = "town.form")
    public String saveTown(
            @ModelAttribute("town") Town town,BindingResult bindingResult) {

        townService.saveTown(town);

        return SUCCESS_VIEW;
    }


}