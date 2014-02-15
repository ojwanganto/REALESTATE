package org.restate.project.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.restate.project.model.Country;
import org.restate.project.model.County;
import org.restate.project.model.Estate;
import org.restate.project.model.House;
import org.restate.project.model.Landlord;
import org.restate.project.model.TenancyAgreement;
import org.restate.project.model.Tenant;
import org.restate.project.model.Unit;
import org.restate.project.service.CountryService;
import org.restate.project.service.CountyService;
import org.restate.project.service.EstateService;
import org.restate.project.service.HouseService;
import org.restate.project.service.LandlordService;
import org.restate.project.service.TenancyAgreementService;
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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("tenancyAgreementForm.aspx")
public class TenancyAgreementFormController {
    @Autowired
    private TenancyAgreementService tenancyAgreementService;

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
    private LandlordService landlordService;


    private static final String LIST_VIEW = "tenancyAgreementList";
    private static final String FORM_VIEW = "tenancyAgreementForm";
    private static final String SUCCESS_VIEW = "redirect:tenancyAgreement.list";

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




    @RequestMapping(method = RequestMethod.GET, value = "tenancyAgreementForm.aspx")
    public String displayCountryForm(
            @RequestParam(value = "id", required = false) Integer id,
            ModelMap modelMap) {

        TenancyAgreement tenancyAgreement = null;

        if (id != null)
            tenancyAgreement = tenancyAgreementService.getTenancyAgreementById(id);

        if (id == null) {
            tenancyAgreement = new TenancyAgreement();
        }

        modelMap.put("tenancyAgreement", tenancyAgreement);

        return FORM_VIEW;
    }

    @RequestMapping(method = RequestMethod.POST, value = "tenancyAgreementForm.aspx")
    public String saveTenancyAgreement(
            @ModelAttribute("tenancyAgreement") TenancyAgreement tenancyAgreement,BindingResult bindingResult) {

        //Generate Reference Number
        SimpleDateFormat dateFormat = new SimpleDateFormat("ddmmyyy");
        dateFormat.format(new Date());

        Unit selUnit = unitService.getUnitById(tenancyAgreement.getUnit().getId());
        House selHouse = selUnit.getHouse();
        Landlord selLandlord = selHouse.getLandlord();
        tenancyAgreement.setDateCreated(new Date());
        tenancyAgreement.setLandlord(selLandlord);
        tenancyAgreement.setHouse(selHouse);
        tenancyAgreement.setReferenceNumber(selLandlord.getId() + "/" + selHouse.getId()+"/"+selUnit.getId());
        tenancyAgreementService.saveTenancyAgreement(tenancyAgreement);

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