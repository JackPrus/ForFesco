package by.prus.forfesco.controller;

import by.prus.forfesco.model.entity.Fact;
import by.prus.forfesco.service.interfaces.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/link")
public class LinkController {

    @Autowired
    LinkService linkService;

    @PutMapping(
            path = "/createLinks",
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public String createLinks() {
        return linkService.createSynchronizationPlaneAndFact();
    }

}
