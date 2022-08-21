package by.prus.forfesco.controller;

import by.prus.forfesco.dao.AgentRepostory;
import by.prus.forfesco.model.entity.Agent;
import by.prus.forfesco.model.enums.ErrorReason;
import by.prus.forfesco.myexception.EntityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agent")
public class AgentController {

    @Autowired
    AgentRepostory agentRepostory;

    //http://localhost:8080/forfesco/agent/4
    @GetMapping(
            path = "{id}",
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
    )
    public Agent getAgent(@PathVariable String id) {
        return agentRepostory.findByAgentCode(id).orElseThrow(() -> new EntityException(ErrorReason.OBJECT_BY_ID_NOT_FOUND.getDescriprtion()));
    }

    //http://localhost:8080/forfesco/agent/findall
    @GetMapping(
            path = "/findall",
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public List<Agent> getAgents() {
        return agentRepostory.findAll();
    }

    @PostMapping(
            path = "/create",
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
    )
    public Agent createAgent(@RequestBody Agent agentRequest) {
        if (agentRequest.getAgentName().isEmpty()) {
            throw new EntityException(ErrorReason.EMPTY_OBJECT.getDescriprtion());
        }
        return agentRepostory.save(agentRequest);
    }
}
