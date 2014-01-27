package org.restate.project.service;

import org.restate.project.model.Country;
import org.restate.project.model.Enquiry;

import java.util.List;

/**
 * service class for Enquiry class
 */
public interface EnquiryService {

    public Enquiry saveEnquiry(Enquiry enquiry);
    public Enquiry getEnquiryById(Integer id);
    public List<Enquiry> getEnquiryList();

}
