package org.restate.project.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.restate.project.model.Estate;
import org.restate.project.service.EstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("estate.form")
public class EstateFormController {
    @Autowired
    private EstateService estateService;

    private static final String LIST_VIEW = "estateList";
    private static final String FORM_VIEW = "estateForm";
    private static final String SUCCESS_VIEW = "redirect:estate.list";

    private final Log log = LogFactory.getLog(this.getClass());

    @RequestMapping(method = RequestMethod.GET, value = "estate.form")
    public String displayEstateForm(
            @RequestParam(value = "cid", required = false) Integer cid,
            ModelMap modelMap) {

        Estate estate = null;

        if (cid != null)
            estate = estateService.getEstateById(cid);

        if (cid == null) {
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