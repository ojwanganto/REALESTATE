package org.restate.project.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.restate.project.model.Agent;
import org.restate.project.model.Payment;
import org.restate.project.service.AgentService;
import org.restate.project.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("payments.list")
public class PaymentListController {
    @Autowired
    private PaymentService paymentService;

    private static final String LIST_VIEW = "paymentsList";

    private final Log log = LogFactory.getLog(this.getClass());

	@RequestMapping(method = RequestMethod.GET)
	public String printPaymentsList(ModelMap model) {

        List<Payment> payments = paymentService.getPaymentList();

		model.addAttribute("payments", payments);
		return LIST_VIEW;
	}





}