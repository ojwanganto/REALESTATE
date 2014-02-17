package org.restate.project.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.restate.project.model.Agent;
import org.restate.project.model.Country;
import org.restate.project.service.AgentService;
import org.restate.project.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("agent.list")
public class AgentListController {
    @Autowired
    private AgentService agentService;

    private static final String LIST_VIEW = "agentList";

    private final Log log = LogFactory.getLog(this.getClass());

	@RequestMapping(method = RequestMethod.GET)
	public String printAgentList(ModelMap model) {

        Agent agent = agentService.getAgent();

		model.addAttribute("agent", agent);
		return LIST_VIEW;
	}





}