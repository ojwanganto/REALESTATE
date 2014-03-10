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
import org.restate.project.model.Agent;
import org.restate.project.model.TenancyAgreement;
import org.restate.project.model.Tenant;
import org.restate.project.reports.TenancyAgreementModel;
import org.restate.project.service.AgentService;
import org.restate.project.service.TenancyAgreementService;
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
@RequestMapping("tenancyAgreementDownload.aspx")
public class TenancyAgreementDownloadController {

    private Log log = LogFactory.getLog(this.getClass());

    @Autowired
    private TenancyAgreementService tenancyAgreementService;

    @Autowired
    private AgentService agentService;


    @RequestMapping(method = RequestMethod.GET, value = "tenancyAgreementDownload.aspx")
    public void downloadDocument(HttpServletResponse response,
                                 @RequestParam(value = "aid", required = false) Integer aid) throws Exception {


        if(aid ==null){
            return;
        }

        TenancyAgreement thisAgreement = tenancyAgreementService.getTenancyAgreementById(aid);

        TenancyAgreementModel model = new TenancyAgreementModel();

        /*Get tenant*/
        Tenant thisTenant = thisAgreement.getTenant();

       /*Populate agent details*/
        model.setAgentAddress(this.getAgent().getAddress());
        model.setAgentCellPhone(this.getAgent().getPhoneContact());
        model.setAgentName(this.getAgent().getName());

        /*populate tenant relevant details*/

        model.setTenantAddress(thisTenant.getAddress());
        model.setTenantCellPhone(thisTenant.getPhoneNumber());
        model.setTenantIDNo(thisTenant.getNationalIdNo());
        model.setTenantName(thisTenant.getName());
        model.setHouseName(thisAgreement.getHouse().getName());

        /*Get current date*/
        Date now = new Date();

        SimpleDateFormat formatCurentDate = new SimpleDateFormat("dd/mm/yyyy");
        SimpleDateFormat formatEffectiveDate = new SimpleDateFormat("MMM yyyy");

        String thisDate = formatCurentDate.format(now);
        String effectiveDate = formatEffectiveDate.format(thisAgreement.getStartDate());
        String expiryDate = formatEffectiveDate.format(thisAgreement.getExpiry());

        /*Set model appropriately*/
        model.setEffectiveDate(effectiveDate);
        model.setExpiryDate(expiryDate);
        model.setCurrentDate(thisDate);

        model.setRent(thisAgreement.getRentPayable().toString());



        WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.createPackage();

        wordMLPackage.getMainDocumentPart()
                .addStyledParagraphOfText("Heading1", " REPUBLIC OF KENYA");
        wordMLPackage.getMainDocumentPart()
                .addStyledParagraphOfText("Heading1", " TENANCY AGREEMENT");


        wordMLPackage.getMainDocumentPart().addParagraphOfText("THIS TENANCY AGREEMENT made on " +model.getCurrentDate()+ " Between " + model.getAgentName() +" OF " + model.getAgentAddress() +". CELL PHONE No. " + model.getAgentCellPhone() + " hereinafter referred to as the “AGENT” AND THE MANAGERS OF THE PROPERTY KNOWN AS " + model.getHouseName() + " of one part which expression shall where the context so admits includes his heirs’ representatives and assigns and " + model.getTenantName() + " OF P.O BOX " + model.getTenantAddress() + ". ID No. "+ model.getTenantIDNo() + " CELL PHONE No. "+ model.getTenantCellPhone() + " Hereafter referred as the “Tenant” of the other part which expression shall where the context so admits include her heirs representatives and assigns.");
        wordMLPackage.getMainDocumentPart()
                .addParagraphOfText("WHERE AS the Landlord/ Agent is desirous of letting the house, for period of one Year, with effect from " + model.getEffectiveDate());

        wordMLPackage.getMainDocumentPart()
                .addStyledParagraphOfText("Heading1", "NOW THIS TENANCY AGREEMENT WITNESSED AS HERE UNDER:");

        wordMLPackage.getMainDocumentPart()
                .addParagraphOfText("1. The Agents/ Landlord/ Landlady agrees to let and the tenant accept to lease the said premises.");
        wordMLPackage.getMainDocumentPart()
                .addParagraphOfText("2. This tenancy agreement shall commence from " + model.getEffectiveDate() +" and end on " + model.getExpiryDate() + " and to be renewed after determination mutandis, mutandis.");

        wordMLPackage.getMainDocumentPart()
                .addParagraphOfText("3. The parties have mutually agreed on a Monthly payment of Ksh. " +  model.getRent() + " with a deposit equivalent to one month’s rent which sum is refundable at the termination of his/ her tenancy with proper notice. HOWEVER, the sum may be utilized to defray any outstanding conservancy and/or renovation, redecoration charges or expenses which at all material times be payable by the Tenant within the tenancy period.");

        wordMLPackage.getMainDocumentPart()
                .addParagraphOfText("4. The parties have mutually agreed that the rent for every month shall be payable on or before the 5th day of each due month and shall be paid to the landlord/ appointed Agents.");



        wordMLPackage.getMainDocumentPart()
                .addParagraphOfText("5. The tenant should NOTE that impediment in rent payment without proper consultation with the landlord/ agents on or before the end of every month will attracts penalty of 500/= for every single day from the date line given.  \n" +
                        "Electricity and water bills should be cleared immediately after receiving the bills of each month");


        wordMLPackage.getMainDocumentPart()
                .addParagraphOfText("6. The Tenant shall agree with the Agent/ Landlord/ Landlady as follows:");


        wordMLPackage.getMainDocumentPart()
                .addParagraphOfText("a) At the termination of the said term of tenancy to deliver up the demised Premises together with the Landlord’s fixtures therein with all locks, keys and fastenings complete and in such state of repair order and conditioned shall be in strict compliance with the conservation the part of the lease herein contained.");


        wordMLPackage.getMainDocumentPart()
                .addParagraphOfText("b) The Tenant may at any time during the continuance of the term hereby terminate the lease by giving one month’s notice or by payment of one month’s rent in lieu of the notice. The landlord may terminate the lease by giving the Tenant two months notice at his own discretion.");


        wordMLPackage.getMainDocumentPart()
                .addParagraphOfText("c) To permit the landlord/ Landlady, his agents, workmen or servants at all reasonable times on written notice from the Landlord to enter upon the demised premises or any part thereof and execute structural or other repairs to the buildings of which the demised premises or part or the electrical circuits, water pipes and drains in or under the same or any other repairs which the Landlord may be liable to carry out hereunder.");

        wordMLPackage.getMainDocumentPart()
                .addParagraphOfText("d) To use the demised premises for private and residential purposes only and not to carry on any other business or use them for any other unlawful or unauthorized activities/ dealings.");

        wordMLPackage.getMainDocumentPart()
                .addParagraphOfText("e) Not to sublet the demised premises or any part thereof during the period of the tenancy without the consent in writing of the Landlord/Landlady or his authorized agents: such consent not to be unreasonably withheld.");

        wordMLPackage.getMainDocumentPart()
                .addParagraphOfText("f) At the termination of the term created (however determined) to paint with two coats of paint and in such a manner and in styles as the Landlady/ Landlord may reasonably determine all the inside part of demised premises previously or usually painted and to buff upon polish wood (if any) in a proper and workman like manner and to the reasonable satisfaction of the landlord/ landlady depending o the condition of the house before occupations which inspection/ inventory shall be done prior to the signing of this agreement.");

        wordMLPackage.getMainDocumentPart()
                .addParagraphOfText("g) To keep the demised premises/ fittings and fixtures there in clean and in good condition. To hand over the property fittings and fixtures at the expiry of the termination/ tenancy in the same condition and repair as in entry; fair wear and tear expected.");

        wordMLPackage.getMainDocumentPart()
                .addParagraphOfText("h) To pay for the replacement or make good repair or restore all such fixtures and fittings as shall be broken, lost or damaged or destroyed during the tenancy and to replace all keys (or the appropriate locks which are shown on the inventory and which are lost, broken or damaged)");

        wordMLPackage.getMainDocumentPart()
                .addParagraphOfText("i) To be responsible for all damages, which are incurred as a result of the negligence or willful act on the part of the tenant and/ or occupant to walls, ceiling, floors, windows and doors and will repair the same at his own expense if required to do so by the landlord/ landlady or his authorized agents.");

        wordMLPackage.getMainDocumentPart()
                .addParagraphOfText("j) To be responsible for all the normal running, repairs and maintenance in connection with the internal plumbing, fixtures, furniture, fittings, heaters, windows, lock handles and fasteners and should ensure that they are in working order before taking occupation on the demised premises.");

        wordMLPackage.getMainDocumentPart()
                .addParagraphOfText("k) Not to do or permit or suffer to be done anything whereby any insurance or the demised premises against the loss of the damage by fire may become void or voidable or whereby the rate of premium for any such insurance may be increased and not to pay by the landlord/ landlady all sums paid by way of increased premiums and or expense incurred by him I or about renewal of any such policy rendered necessary by a breach of his covenant and all such payments shall be added to the rent herein before reserved and shall be recoverable as rent.");

        wordMLPackage.getMainDocumentPart()
                .addParagraphOfText("l) Not to do or permit or suffer to be done anything in or upon the demised premises or any part thereof which may be at any time become a nuisance or annoyance to the neighbors or injurious or detrimental to the reputation of the demise premises.");

        wordMLPackage.getMainDocumentPart()
                .addParagraphOfText("m) To take every reasonable precaution to ensure that the presence of any dry or wet rot or white ants or other destructive insects or pests do not gain access to the said premises and to notify the Landlord/ Landlady forthwith in the event of any infestations appearing.");



        //Landlords
        wordMLPackage.getMainDocumentPart().addStyledParagraphOfText("Heading1",
                "The Landlord/ Landlady hereby agrees with the Tenant as follows:-");

        wordMLPackage.getMainDocumentPart()
                .addParagraphOfText("a) That in the event of the premises or any part thereof being damaged by fire during continuance of the tenancy hereby created so as to render them outfit for occupation allows the tenant a total or appropriate abatement of rent provided that such fire is not due to the fault or negligence of the tenant.");
        wordMLPackage.getMainDocumentPart()
                .addParagraphOfText("b) To pay ground rent (if any) and the unimproved site value tax together with all increase in site value tax and land rent, rates taxed, charges outgoings, impositions and assessments which now or may hereafter be imposed as assed by respective authority in respect of the demised premises after the commencement of the tenancy.");

        wordMLPackage.getMainDocumentPart()
                .addParagraphOfText("c) To keep the structure, roof and outside of the buildings and premises in good state of repair and painted where necessary");

        wordMLPackage.getMainDocumentPart()
                .addParagraphOfText("d) To permit the tenant paying the rent hereby reserved and performing and observing the covenants and agreements herein contained or implied and on its part to be performed and observed peaceable and quietly to posses and enjoy the demised premises during the said term created without any interruption from or by the landlord/ landlady or any other persons lawful claiming from or under him.");

        wordMLPackage.getMainDocumentPart().addStyledParagraphOfText("Heading1",
                "IT IS HEREBY AGREED between the landlord/landlady and the Tenant as follows:-");

        wordMLPackage.getMainDocumentPart()
                .addParagraphOfText("a) The landlord/landlady or his authorized agents reserve the right to enter the demised premise to carry inspection and will first obtain permission of the tenant to enter such premise not to be unreasonably withheld AND THE TENANT WILL ALSO during the last one month of the tenancy permit any other persons to enter and inspect the demised premises at reasonable time upon production of any order to view from the landlord/ landlady or her authorized agents.");

        wordMLPackage.getMainDocumentPart()
                .addParagraphOfText("b) If the rent any time during the period of the tenancy becomes more than (7) days arrears, whether legally demanded or not or if the tenant shall omit to perform or observe any of the covenants herein contained to the landlord/landlady or his authorized agents, reserve the right to terminate the tenancy and assume the possession of the demised premises immediately and take whatever action they think fit to recover the arrears of the rent.");

        wordMLPackage.getMainDocumentPart()
                .addParagraphOfText("c) Any notices required to be served hereunder shall be in writing and shall in the case of the Tenant by sufficiently served if addresses to her and delivered to the demised premises and in the case of notices to the landlord/landlady sufficiently served if addressed to his authorized agents and delivered to their office or posted to the Tenant registered post and so that any notice so posted shall be deemed to have been served within given days following the day of posting.");

        wordMLPackage.getMainDocumentPart()
                .addParagraphOfText("d) That this agreement does not prevent the landlord/landlady from carrying out further development on the said plot provided that should such a need arise, then the landlord/landlady shall duly give the tenant three (3) months notice of such intention.");

        wordMLPackage.getMainDocumentPart()
                .addParagraphOfText("e) The parties hereby agree to pay legal fee   to effect this agreement");

        wordMLPackage.getMainDocumentPart().addStyledParagraphOfText("Heading3",
                "Signed by said Landlord/ Agent;");

        wordMLPackage.getMainDocumentPart().addStyledParagraphOfText("Heading3",
                "___________________________________________");


        wordMLPackage.getMainDocumentPart().addStyledParagraphOfText("Heading3",
                "Signed by the said Tenant;");


        wordMLPackage.getMainDocumentPart().addStyledParagraphOfText("Heading3",
                "___________________________________________");


        wordMLPackage.getMainDocumentPart().addStyledParagraphOfText("Heading3",
                "In the presence of;");

        wordMLPackage.getMainDocumentPart().addStyledParagraphOfText("Heading3",
                "___________________________________________");

        wordMLPackage.getMainDocumentPart().addStyledParagraphOfText("Heading3",
                "DRAWN BY:-");

        wordMLPackage.getMainDocumentPart().addStyledParagraphOfText("Heading3",
                model.getAgentName());

        //create a new file

        File tmpFile = File.createTempFile("agreementDocs", ".docx");
        wordMLPackage.save(tmpFile);
        response.setHeader("Content-disposition", "attachment; filename=" + model.getTenantName() + ".docx");
        response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
        //response.setContentType("application/octet-stream");
        OutputStream outputStream = response.getOutputStream();
        FileInputStream fileInputStream = new FileInputStream(tmpFile);

        IOUtils.copy(fileInputStream, outputStream);
        fileInputStream.close();
        outputStream.flush();

        tmpFile.delete();
    }

    private Agent getAgent(){
        return agentService.getAgent();
    }

}
