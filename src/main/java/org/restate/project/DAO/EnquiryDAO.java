package org.restate.project.DAO;

import org.restate.project.model.Country;
import org.restate.project.model.Enquiry;

import java.util.List;

/**
 * TODO:please provide a brief description for the class.
 */
public interface EnquiryDAO {
    public Enquiry saveEnquiry(Enquiry enquiry);
    public Enquiry getEnquiryById(Integer id);
    public List<Enquiry> getEnquiryList();
}
