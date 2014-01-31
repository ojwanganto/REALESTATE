package org.restate.project.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("manageHouse.aspx")
public class ManageHouseController {

    private final Log log = LogFactory.getLog(this.getClass());
    private static final String FORM_VIEW = "manageHouse";

    @RequestMapping(method = RequestMethod.GET, value = "manageHouse")
    public String displayCountryForm() {

        return FORM_VIEW;
    }


}