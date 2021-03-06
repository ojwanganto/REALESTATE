package org.restate.project.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.restate.project.model.House;
import org.restate.project.model.Unit;
import org.restate.project.service.CountyService;
import org.restate.project.service.EstateService;
import org.restate.project.service.HouseService;
import org.restate.project.service.TenancyAgreementService;
import org.restate.project.service.TenantService;
import org.restate.project.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("ajaxCalls")
public class AjaxCallsController {
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


    private final Log log = LogFactory.getLog(this.getClass());

    @RequestMapping("houseList/{id}")
    @ResponseBody
    public List<House> getHousesInEstate(@PathVariable Integer id) {
        return houseService.getHousesByEstate(estateService.getEstateById(id));
    }



    @RequestMapping("unitList/{id}")
    @ResponseBody
    public List<Unit> getUnitsInHouse(@PathVariable Integer id) {

        return unitService.getVacantUnitByHouse(houseService.getHouseById(id));
    }

    @RequestMapping("unitList/{houseId}/{tenantId}")
    @ResponseBody
    public List<Unit> getUnitsOfTenantByHouse(@PathVariable Integer houseId,@PathVariable Integer tenantId) {

        return tenancyAgreementService.getUnitsOfATenantByHouse(tenantService.getTenantById(tenantId), houseService.getHouseById(houseId));
    }


}