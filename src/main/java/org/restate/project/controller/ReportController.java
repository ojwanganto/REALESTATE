package org.restate.project.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.restate.project.model.Country;
import org.restate.project.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("report.asp")
public class ReportController {

    private final Log log = LogFactory.getLog(this.getClass());
    private static final String FORM_VIEW = "report";

    @RequestMapping(method = RequestMethod.GET, value = "report")
    public String displayCountryForm() {

        return FORM_VIEW;
    }


}