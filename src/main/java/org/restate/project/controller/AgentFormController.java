package org.restate.project.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.restate.project.model.Agent;
import org.restate.project.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("agent.form")
public class AgentFormController {
    @Autowired
    private AgentService agentService;

    private static final String LIST_VIEW = "agentList";
    private static final String FORM_VIEW = "agentForm";
    private static final String SUCCESS_VIEW = "redirect:agent.list";

    private final Log log = LogFactory.getLog(this.getClass());

    @RequestMapping(method = RequestMethod.GET, value = "agent.form")
    public String displayAgentForm(
            @RequestParam(value = "id", required = false) Integer id,
            ModelMap modelMap) {

        Agent agent = null;

        if (id != null)
            agent = agentService.getAgent();

        if (id == null) {
            agent = new Agent();
        }

        modelMap.put("agent", agent);

        return FORM_VIEW;
    }

    @RequestMapping(method = RequestMethod.POST, value = "agent.form")
    public String saveAgent(
            @ModelAttribute("agent") Agent agent,BindingResult bindingResult) {

        agentService.saveAgent(agent);

        return SUCCESS_VIEW;
    }


}