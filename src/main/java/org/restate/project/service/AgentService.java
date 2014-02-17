package org.restate.project.service;

import org.restate.project.model.Agent;
import org.restate.project.model.Country;

import java.util.List;

/**
 * service class for Agent class
 */
public interface AgentService {

    public Agent saveAgent(Agent agent);
    public Agent getAgent();

}
