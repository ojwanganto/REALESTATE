package org.restate.project.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.restate.project.model.Country;
import org.restate.project.model.County;
import org.restate.project.model.Estate;
import org.restate.project.model.House;
import org.restate.project.model.Landlord;
import org.restate.project.model.Payment;
import org.restate.project.model.Tenant;
import org.restate.project.model.Unit;
import org.restate.project.service.CountryService;
import org.restate.project.service.CountyService;
import org.restate.project.service.EstateService;
import org.restate.project.service.HouseService;
import org.restate.project.service.LandlordService;
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
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("rentPayment.form")
public class RentPaymentFormController {
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

    private static final String LIST_VIEW = "rentDepositList";
    private static final String FORM_VIEW = "rentPaymentForm";
    private static final String SUCCESS_VIEW = "redirect:landlord.list";

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


    @RequestMapping(method = RequestMethod.GET, value = "rentPayment.form")
    public String displayLandlordForm(
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

    @RequestMapping(method = RequestMethod.POST, value = "rentPayment.form")
    public String savePayment(
            @ModelAttribute("payment") Payment payment,BindingResult bindingResult) {


        payment.setPaymentType(paymentTypeService.getPaymentTypeById(1));
        paymentService.savePayment(payment);

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