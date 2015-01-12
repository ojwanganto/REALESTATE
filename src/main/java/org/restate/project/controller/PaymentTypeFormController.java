package org.restate.project.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.restate.project.model.Estate;
import org.restate.project.model.PaymentType;
import org.restate.project.model.Town;
import org.restate.project.service.EstateService;
import org.restate.project.service.PaymentTypeService;
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
@RequestMapping("paymentType.form")
public class PaymentTypeFormController {
    @Autowired
    private PaymentTypeService paymentTypeService;

    private static final String LIST_VIEW = "estateList";
    private static final String FORM_VIEW = "paymentTypeForm";
    private static final String SUCCESS_VIEW = "redirect:paymentType.list";

    private final Log log = LogFactory.getLog(this.getClass());

    @RequestMapping(method = RequestMethod.GET, value = "paymentType.form")
    public String displayPaymentTypeForm(
            @RequestParam(value = "id", required = false) Integer id,
            ModelMap modelMap) {

        PaymentType paymentType = null;

        if (id != null)
            paymentType = paymentTypeService.getPaymentTypeById(id);

        if (id == null) {
            paymentType = new PaymentType();
        }

        modelMap.put("paymentType", paymentType);

        return FORM_VIEW;
    }

    @RequestMapping(method = RequestMethod.POST, value = "paymentType.form")
    public String saveEstate(
            @ModelAttribute("paymentType") PaymentType paymentType,BindingResult bindingResult) {

        paymentTypeService.savePaymentType(paymentType);

        return SUCCESS_VIEW;
    }


}