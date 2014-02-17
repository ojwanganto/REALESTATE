package org.restate.project.service.impl;

import org.restate.project.DAO.AgentDAO;
import org.restate.project.DAO.CountryDAO;
import org.restate.project.model.Agent;
import org.restate.project.model.Country;
import org.restate.project.service.AgentService;
import org.restate.project.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * implementation class for AgentService class
 */
public class AgentServiceImpl implements AgentService {

    @Autowired
    private AgentDAO agentDAO;

    @Override
    public Agent saveAgent(Agent agent) {
        return agentDAO.saveAgent(agent);
    }

    @Override
    public Agent getAgent() {
        return agentDAO.getAgent();
    }


}
