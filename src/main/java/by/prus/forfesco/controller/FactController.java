package by.prus.forfesco.controller;

import by.prus.forfesco.model.entity.Fact;
import by.prus.forfesco.service.interfaces.FactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fact")
public class FactController {

    @Autowired
    private FactService factService;

    @GetMapping(
            path = "/findall",
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public List<Fact> getFacts() {
        return factService.findAll();
    }

    @GetMapping(
            path = "/findbyagentandop",
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public List<Fact> getFactsOfAgent(@RequestParam String agent, @RequestParam String operation) {
        return factService.findByAgentAndOperation(agent, operation);
    }

}
