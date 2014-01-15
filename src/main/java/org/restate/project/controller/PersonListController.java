package org.restate.project.controller;

import org.restate.project.model.Person;
import org.restate.project.service.PersonService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("person.list")
public class PersonListController {
    @Autowired
    private PersonService personService;

    private static final String LIST_VIEW = "personlist";
    private static final String FORM_VIEW = "createperson";

    private final Log log = LogFactory.getLog(PersonListController.class);

	@RequestMapping(method = RequestMethod.GET)
	public String printPersonList(ModelMap model) {

        List<Person> persons = personService.getPersonsList();

		model.addAttribute("persons", persons);
		return LIST_VIEW;
	}





}