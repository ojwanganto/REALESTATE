package org.restate.project.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.restate.project.model.House;
import org.restate.project.model.PaymentType;
import org.restate.project.service.HouseService;
import org.restate.project.service.PaymentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("paymentType.list")
public class PaymentTypeListController {
    @Autowired
    private PaymentTypeService paymentTypeService;

    private static final String LIST_VIEW = "paymentTypeList";

    private final Log log = LogFactory.getLog(this.getClass());

	@RequestMapping(method = RequestMethod.GET)
	public String printPersonList(ModelMap model) {

        List<PaymentType> paymentTypes = paymentTypeService.getPaymentTypeList();

		model.addAttribute("paymentTypes", paymentTypes);
		return LIST_VIEW;
	}





}