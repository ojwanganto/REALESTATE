package org.restate.project.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.restate.project.model.House;
import org.restate.project.model.Landlord;
import org.restate.project.model.LandlordAgreement;
import org.restate.project.service.HouseService;
import org.restate.project.service.LandlordAgreementService;
import org.restate.project.service.LandlordService;
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
@RequestMapping("landlordAgreementForm.aspx")
public class LandlordAgreementFormController {
    @Autowired
    private LandlordAgreementService landlordAgreementService;

    @Autowired
    private HouseService houseService;

    @Autowired
    private LandlordService landlordService;


    private static final String LIST_VIEW = "landlordAgreementList";
    private static final String FORM_VIEW = "landlordAgreementForm";
    private static final String SUCCESS_VIEW = "redirect:landlordAgreement.list";

    private final Log log = LogFactory.getLog(this.getClass());

    @ModelAttribute("houses")
    public List<House> getHouses() {
        return houseService.getUnassignedHouseList();
    }

    @ModelAttribute("landlords")
    public List<Landlord> getLandlordList() {
        return landlordService.getLandlordList();
    }




    @RequestMapping(method = RequestMethod.GET, value = "landlordAgreementForm.aspx")
    public String displayCountryForm(
            @RequestParam(value = "id", required = false) Integer id,
            ModelMap modelMap) {

        LandlordAgreement landlordAgreement = null;

        if (id != null)
            landlordAgreement = landlordAgreementService.getLandlordAgreementById(id);

        if (id == null) {
            landlordAgreement = new LandlordAgreement();
        }

        modelMap.put("landlordAgreement", landlordAgreement);

        return FORM_VIEW;
    }

    @RequestMapping(method = RequestMethod.POST, value = "landlordAgreementForm.aspx")
    public String saveLandlordAgreement(
            @ModelAttribute("landlordAgreement") LandlordAgreement landlordAgreement,BindingResult bindingResult) {

        //Generate Reference Number
        SimpleDateFormat dateFormat = new SimpleDateFormat("ddmmyyy");
        dateFormat.format(new Date());


        landlordAgreement.setDateCreated(new Date());
		House house = landlordAgreement.getHouse();
		house.setAssigned(true);
        landlordAgreement.setReferenceNumber(landlordAgreement.getLandlord().getId() + "/" + landlordAgreement.getHouse().getId());
        if(landlordAgreement !=null){
        	landlordAgreementService.saveLandlordAgreement(landlordAgreement);
			houseService.saveHouse(house);
        }
        else {
            log.info("Object to be saved was null");
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