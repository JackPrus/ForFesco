package by.prus.forfesco.controller;

import by.prus.forfesco.model.entity.Planed;
import by.prus.forfesco.service.interfaces.PlanedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/planed")
public class PlanedController {

    @Autowired
    private PlanedService planedService;

    @GetMapping(
            path = "/findall",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public List<Planed> getAllPlaned() {
        return planedService.findAll();
    }
}
