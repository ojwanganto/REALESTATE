package org.restate.project.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("outPayments.aspx")
public class OutPaymentsController {

    private final Log log = LogFactory.getLog(this.getClass());
    private static final String FORM_VIEW = "outPayments";

    @RequestMapping(method = RequestMethod.GET, value = "outPayments")
    public String displayOutPaymentsForm() {

        return FORM_VIEW;
    }


}