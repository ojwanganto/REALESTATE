package org.restate.project.controller;

import org.restate.project.model.Country;
import org.restate.project.model.Person;
import org.restate.project.service.CountryService;
import org.restate.project.service.PersonService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@RequestMapping("/")
@SessionAttributes("person")
public class PersonFormController {
    @Autowired
    private PersonService personService;

    @Autowired
    private CountryService countryService;

    private static final String LIST_VIEW = "personlist";
    private static final String FORM_VIEW = "createperson";
    private static final String SUCCESS_VIEW = "redirect:person.list";

    private final Log log = LogFactory.getLog(this.getClass());

    @ModelAttribute("countries")
    public List<Country> getCountries() {
        return countryService.getCountryList();
    }

	@RequestMapping(method = RequestMethod.GET,value = "index")
	public String printWelcome(ModelMap model) {

		model.addAttribute("message", "Feel Welcome to use the System'");
		return "index";
	}



    @RequestMapping(method = RequestMethod.GET, value = "createperson.form")
    public String displayPersonForm(
            @RequestParam(value = "personId", required = false) Integer personId,
            ModelMap modelMap) {

        Person person = null;

        if (personId != null)
            person = personService.getPersonById(personId);

        if (personId == null) {
            person = new Person();
        }

        modelMap.put("person", person);

        return FORM_VIEW;
    }

    @RequestMapping(method = RequestMethod.POST, value = "createperson.form")
    public String savePerson(
            @ModelAttribute("person") Person person,BindingResult bindingResult) {

        personService.savePerson(person);

        return SUCCESS_VIEW;
    }


}