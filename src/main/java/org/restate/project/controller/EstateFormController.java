package org.restate.project.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.restate.project.model.Estate;
import org.restate.project.model.Town;
import org.restate.project.service.EstateService;
import org.restate.project.service.TownService;
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
@RequestMapping("estate.form")
public class EstateFormController {
    @Autowired
    private EstateService estateService;

    @Autowired
    private TownService townService;

    private static final String LIST_VIEW = "estateList";
    private static final String FORM_VIEW = "estateForm";
    private static final String SUCCESS_VIEW = "redirect:estate.list";

    private final Log log = LogFactory.getLog(this.getClass());

    @ModelAttribute("towns")
    public List<Town> getTowns() {
        return townService.getTownList();
    }

    @RequestMapping(method = RequestMethod.GET, value = "estate.form")
    public String displayEstateForm(
            @RequestParam(value = "id", required = false) Integer id,
            ModelMap modelMap) {

        Estate estate = null;

        if (id != null)
            estate = estateService.getEstateById(id);

        if (id == null) {
            estate = new Estate();
        }

        modelMap.put("estate", estate);

        return FORM_VIEW;
    }

    @RequestMapping(method = RequestMethod.POST, value = "estate.form")
    public String saveEstate(
            @ModelAttribute("estate") Estate estate,BindingResult bindingResult) {

        estateService.saveEstate(estate);

        return SUCCESS_VIEW;
    }


}