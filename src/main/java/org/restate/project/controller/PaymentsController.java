package org.restate.project.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.restate.project.model.County;
import org.restate.project.model.Estate;
import org.restate.project.model.House;
import org.restate.project.model.Payment;
import org.restate.project.model.PaymentDetails;
import org.restate.project.model.PaymentMode;
import org.restate.project.model.PaymentType;
import org.restate.project.model.Tenant;
import org.restate.project.model.Unit;
import org.restate.project.service.CountyService;
import org.restate.project.service.EstateService;
import org.restate.project.service.HouseService;
import org.restate.project.service.PaymentDetailsService;
import org.restate.project.service.PaymentModeService;
import org.restate.project.service.PaymentService;
import org.restate.project.service.PaymentTypeService;
import org.restate.project.service.TenantService;
import org.restate.project.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("payments.form")
public class PaymentsController {
    @Autowired
    private HouseService houseService;

    @Autowired
    private EstateService estateService;

    @Autowired
    private CountyService countyService;

    @Autowired
    private TenantService tenantService;

    @Autowired
    private UnitService unitService;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private PaymentTypeService paymentTypeService;

	@Autowired
	private PaymentModeService paymentModeService;

	@Autowired
	private PaymentDetailsService paymentDetailsService;


    private static final String LIST_VIEW = "rentDepositList";
    private static final String FORM_VIEW = "paymentForm";
    private static final String SUCCESS_VIEW = "redirect:payments.list";

    private final Log log = LogFactory.getLog(this.getClass());

    @ModelAttribute("tenants")
    public List<Tenant> getTenants() {
        return tenantService.getTenantList();
    }

    @ModelAttribute("estates")
    public List<Estate> getEstates() {
        return estateService.getEstateList();
    }

    @ModelAttribute("counties")
    public List<County> getCounties() {
        return countyService.getCountyList();
    }

    @ModelAttribute("houses")
    public List<House> getHouses() {
        return houseService.getHouseList();
    }

    @ModelAttribute("units")
    public List<Unit> getUnitList() {
        return unitService.getUnitList();
    }

	@ModelAttribute("period")
	public List<String> getNamesOfMonths (){
		List<String> names = new ArrayList<String>(Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"));
		return names;
	}

	@ModelAttribute("paymentTypes")
	public List<PaymentType> getListOfPaymentTypes(){
		return paymentTypeService.getPaymentTypeList();
	}

	@ModelAttribute("paymentModes")
	public List<PaymentMode> getListOfPaymentModes(){
		return paymentModeService.getPaymentModeList();
	}


    @RequestMapping(method = RequestMethod.GET, value = "payments.form")
    public String showPaymentsForm(
            @RequestParam(value = "id", required = false) Integer id,
            ModelMap modelMap) {

        Payment payment = null;

        if (id != null)
            payment = paymentService.getPaymentById(id);

        if (id == null) {
            payment = new Payment();
        }

        modelMap.put("payment", payment);

        return FORM_VIEW;
    }

    @RequestMapping(method = RequestMethod.POST, value = "payments.form")
    public String savePayment(
			@RequestParam(value = "bank", required = false) String bank,
			@RequestParam(value = "branch", required = false) String branch,
			@RequestParam(value = "receiptNo", required = false) String receiptNo,
			@RequestParam(value = "phoneNo", required = false) String phoneNo,
			@RequestParam(value = "transactionCode", required = false) String transactionCode,
            @ModelAttribute("payment") Payment payment,BindingResult bindingResult) {

		if (payment != null) {

			payment.setPaymentInOut(1);
			Integer paymentMode = payment.getPaymentMode().getId();
			PaymentDetails details = null;

			if (paymentMode ==1 ){
				paymentService.savePayment(payment);
			}
			if (paymentMode == 2 ){

				if (bank != null && branch != null && receiptNo != null) {
					details = new PaymentDetails();
					details.setBankName(bank);
					details.setBankBranch(branch);
					details.setBankTransactionNo(receiptNo);

					Payment p = paymentService.savePayment(payment);
					details.setPayment(p);
					paymentDetailsService.savePaymentDetails(details);

				}
			}

			if (paymentMode == 3) {

				if (phoneNo != null && transactionCode != null) {
					details = new PaymentDetails();
					details.setMobileMoneyTransactionCode(transactionCode);
					details.setMobileNumber(phoneNo);

					Payment p = paymentService.savePayment(payment);
					details.setPayment(p);
					paymentDetailsService.savePaymentDetails(details);
				}
			}

		}

        return SUCCESS_VIEW;
    }

    @InitBinder
    private void dateBinder(WebDataBinder binder) {
        // The date format to parse or output your dates
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

        // Register them as custom editors for the Date type
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}