package org.restate.project.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.restate.project.model.Enquiry;
import org.restate.project.service.EnquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("enquiry.form")
public class EnquiryFormController {
    @Autowired
    private EnquiryService enquiryService;

    private static final String LIST_VIEW = "enquiryList";
    private static final String FORM_VIEW = "enquiryForm";
    private static final String SUCCESS_VIEW = "redirect:enquiry.list";

    private final Log log = LogFactory.getLog(this.getClass());

    @RequestMapping(method = RequestMethod.GET, value = "enquiry.form")
    public String displayEnquiryForm(
            @RequestParam(value = "cid", required = false) Integer cid,
            ModelMap modelMap) {

        Enquiry enquiry = null;

        if (cid != null)
            enquiry = enquiryService.getEnquiryById(cid);

        if (cid == null) {
            enquiry = new Enquiry();
        }

        modelMap.put("enquiry", enquiry);

        return FORM_VIEW;
    }

    @RequestMapping(method = RequestMethod.POST, value = "enquiry.form")
    public String saveEnquiry(
            @ModelAttribute("enquiry") Enquiry enquiry,BindingResult bindingResult) {

        enquiryService.saveEnquiry(enquiry);

        return SUCCESS_VIEW;
    }


}