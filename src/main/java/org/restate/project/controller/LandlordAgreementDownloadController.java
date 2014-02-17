/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */

package org.restate.project.controller;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.restate.project.model.Landlord;
import org.restate.project.model.LandlordAgreement;
import org.restate.project.reports.LandlordAgreementModel;
import org.restate.project.service.LandlordAgreementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("landlordAgreementDownload.aspx")
public class LandlordAgreementDownloadController {

    private static final String SUCCESS_VIEW = "redirect:landlordAgreement.list";
    private Log log = LogFactory.getLog(this.getClass());

    @Autowired
    private LandlordAgreementService landlordAgreementService;

    @RequestMapping(method = RequestMethod.GET, value = "landlordAgreementDownload.aspx")
    public void downloadDocument(HttpServletResponse response,
                                 @RequestParam(value = "aid", required = false) Integer aid) throws Exception {


        if(aid ==null){
            return;
        }

        LandlordAgreement thisAgreement = landlordAgreementService.getLandlordAgreementById(aid);

        LandlordAgreementModel model = new LandlordAgreementModel();

        /*Get tenant*/
        Landlord thisLandlord = thisAgreement.getLandlord();

       /*Populate agent details*/
        model.getAgentAddress();
        model.getAgentCellPhone();
        model.getAgentName();

        /*populate tenant relevant details*/

        model.setLandlordAddress(thisLandlord.getAddress());
        model.setLandlordCellPhone(thisLandlord.getPhoneNumber());
        model.setLandlordIDNo(thisLandlord.getNationalIdNo());
        model.setLandlordName(thisLandlord.getName());
        model.setHouseName(thisAgreement.getHouse().getName());

        /*Get current date*/
        Date now = new Date();

        SimpleDateFormat formatCurentDate = new SimpleDateFormat("dd/mm/yyyy");
        SimpleDateFormat formatEffectiveDate = new SimpleDateFormat("dd MMM yyyy");
        SimpleDateFormat dayOnlyFormat = new SimpleDateFormat("dd");
        SimpleDateFormat monthOnlyFormat = new SimpleDateFormat("MMM");
        SimpleDateFormat yearOnlyFormat = new SimpleDateFormat("yyyy");

        String thisDate = formatCurentDate.format(now);
        String effectiveDate = formatEffectiveDate.format(thisAgreement.getEffectiveDate());
        String expiryDate = formatEffectiveDate.format(thisAgreement.getExpiryDate());

        /*Set model appropriately*/
        model.setEffectiveDate(effectiveDate);
        model.setExpiryDate(expiryDate);
        model.setCurrentDate(thisDate);

        model.setCommissionOnRent(thisAgreement.getCommissionOnRent().toString());
        model.setTenantRentPaymentDeadline(dayOnlyFormat.format(thisAgreement.getTenantsDeadlineForRentPayment()));
        model.setDateOfRentSubmission(dayOnlyFormat.format(thisAgreement.getDateOfRentRemittance()));

        /*format now() properly for the report*/


        WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.createPackage();

        wordMLPackage.getMainDocumentPart()
                .addStyledParagraphOfText("Heading1", " REPUBLIC OF KENYA");
        wordMLPackage.getMainDocumentPart()
                .addStyledParagraphOfText("Heading1", " AGREEMENT OF APPOINTMENT OF AGENT");


        wordMLPackage.getMainDocumentPart().addParagraphOfText("THIS AGREEMENT made this " +dayOnlyFormat.format(now)+ " day of " +monthOnlyFormat.format(now ) + " " + yearOnlyFormat.format(now) + " Between " + model.getLandlordName() +" ID NO.  " + model.getLandlordIDNo() +" (herein referred to as “THE OWNER” whose expression shall where the context so admits include his legal representatives and or assigns) of P.O BOX " + model.getLandlordAddress() + " In the republic of Kenya on one part and " + model.getAgentName() + " (hereinafter referred to as “AGENT” whose expression shall where the context who admit includes their representatives or assigns of  " + model.getAgentAddress()+ "  in the republic of Kenya) on the other part.");

        //Landlords
        wordMLPackage.getMainDocumentPart().addStyledParagraphOfText("Heading1",
                "Witnesseth as follows:-");

        wordMLPackage.getMainDocumentPart()
                .addParagraphOfText("Where the owner is the registered owner of that entire plot known as LR. 5646/008 and has constructed so rental houses and whereas he is desirous of appointing the agent herein as his agent for purposes of collecting rental dues and letting.");

        wordMLPackage.getMainDocumentPart().addStyledParagraphOfText("Heading3",
                "It is now hereby agreed by both parties as follows:");
        wordMLPackage.getMainDocumentPart()
                .addParagraphOfText("1. THAT the owner will appoint the agent as his sole agent for the purposes only of collecting the monthly rent for the houses build on plot No.LR. 5646/008");

        wordMLPackage.getMainDocumentPart()
                .addParagraphOfText("2. THAT all the money collected net commission shall be deposited in the bank or collected by the landlord on or before the " + model.getDateOfRentSubmission() + " of each month.");

        wordMLPackage.getMainDocumentPart()
                .addParagraphOfText("3. THAT the commencement of this agency agreement shall be on the " + model.getEffectiveDate() + " and shall terminate on the " + model.getExpiryDate() + " unless the same is mutually extended.");

        wordMLPackage.getMainDocumentPart()
                .addParagraphOfText("4. THAT the agent will inspect the premises (houses) always and especially before and after the tenant vacate and recommend repairs before the tenant vacates.");

        wordMLPackage.getMainDocumentPart()
                .addParagraphOfText("5. THAT the reconciliation of the accounts shall be done at the end of every month and forwarded to the landlord by means convenient to him/her.");

        wordMLPackage.getMainDocumentPart()
                .addParagraphOfText("6. THAT the agent will be paid " + model.getCommissionOnRent() + "% commission of all the rent paid per month as his fees.");

        wordMLPackage.getMainDocumentPart()
                .addParagraphOfText("7. THAT the owner will be at liberty to vet any tenant before they enter on to tenancy agreement.");

        wordMLPackage.getMainDocumentPart()
                .addParagraphOfText("8. THAT the agent should/ will ensure that tenants pay water and electricity bills.");

        wordMLPackage.getMainDocumentPart()
                .addParagraphOfText("9. THAT this agreement can be terminated by either party serving on the other, one month notice upon which reconciliation of the accounts will be done to ensure no money shall be left owing to the agent or owner.");

        wordMLPackage.getMainDocumentPart()
                .addParagraphOfText("10. Tenants to pay deposit & rent directly to the owners Acc No. 09999999999999 of Acc name " + model.getLandlordName());

        wordMLPackage.getMainDocumentPart()
                .addParagraphOfText("11. The " + model.getTenantRentPaymentDeadline()+ " tenant to pay to the Agent.");

        wordMLPackage.getMainDocumentPart()
                .addParagraphOfText("IN WITNESS WHEREOF both parties have set their hands to these resents in the date therein beforehand.");

        wordMLPackage.getMainDocumentPart().addStyledParagraphOfText("Heading3",
                "SIGNED by the OWNER\n" +
                        "The said " + model.getLandlordName() + "\n" +
                        "\n" +
                        "Sign       …………………………………………     Date…………………………");

        wordMLPackage.getMainDocumentPart().addStyledParagraphOfText("Heading3",
                "SIGNED by the AGENT.\n" +
                         model.getAgentName() + "\n" +
                        "\n" +
                        "Sign       ………………………………………….    Date……………………………");



        wordMLPackage.getMainDocumentPart().addStyledParagraphOfText("Heading3",
                "T/a " +model.getAgentName());


        //create a new file

        File tmpFile = File.createTempFile("landlordAgreementDocs", ".docx");
        wordMLPackage.save(tmpFile);
        response.setHeader("Content-disposition", "attachment; filename=" + model.getLandlordName() + ".docx");
        response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
        //response.setContentType("application/octet-stream");
        OutputStream outputStream = response.getOutputStream();
        FileInputStream fileInputStream = new FileInputStream(tmpFile);

        IOUtils.copy(fileInputStream, outputStream);
        fileInputStream.close();
        outputStream.flush();

        tmpFile.delete();
    }


}
