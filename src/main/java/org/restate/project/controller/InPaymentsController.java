package org.restate.project.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("inPayments.aspx")
public class InPaymentsController {

    private final Log log = LogFactory.getLog(this.getClass());
    private static final String FORM_VIEW = "inPayments";

    @RequestMapping(method = RequestMethod.GET, value = "inPayments")
    public String displayCountryForm() {

        return FORM_VIEW;
    }


}