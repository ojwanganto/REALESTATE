package org.restate.project.service.impl;

import org.restate.project.DAO.EnquiryDAO;
import org.restate.project.model.Enquiry;
import org.restate.project.service.EnquiryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * implementation class for CountryService class
 */
public class EnquiryServiceImpl implements EnquiryService {

    @Autowired
    private EnquiryDAO enquiryDAO;

    @Override
    public Enquiry saveEnquiry(Enquiry enquiry) {
        return enquiryDAO.saveEnquiry(enquiry);
    }

    @Override
    public Enquiry getEnquiryById(Integer id) {
        return enquiryDAO.getEnquiryById(id);
    }

    @Override
    public List<Enquiry> getEnquiryList() {
        return enquiryDAO.getEnquiryList();
    }
}
