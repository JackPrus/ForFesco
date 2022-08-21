package by.prus.forfesco.service;

import by.prus.forfesco.dao.LinkRepository;
import by.prus.forfesco.model.ErrorMessage;
import by.prus.forfesco.model.entity.Fact;
import by.prus.forfesco.model.entity.Link;
import by.prus.forfesco.model.entity.Planed;
import by.prus.forfesco.model.enums.ErrorReason;
import by.prus.forfesco.myexception.EntityException;
import by.prus.forfesco.service.interfaces.FactService;
import by.prus.forfesco.service.interfaces.LinkService;
import by.prus.forfesco.service.interfaces.PlanedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class LinkServiceImpl implements LinkService {

    @Autowired
    PlanedService planedService;
    @Autowired
    FactService factService;
    @Autowired
    LinkRepository linkRepository;

    @Override
    @Transactional
    public String createSynchronizationPlaneAndFact() {
        try {
            List<Fact> notLinkedFacts = factService.findAllByFactSumLinked(null);
            List<Planed> notLinkedPlans = planedService.findAllByPlanSumLinked(null);
            Set<Link> linksToCreate = new HashSet<>();
            Set<Fact> factsToUpdate = new HashSet<>();
            Set<Planed> plansToUpdate = new HashSet<>();
            if (notLinkedFacts != null && !notLinkedFacts.isEmpty() && notLinkedPlans != null && !notLinkedPlans.isEmpty()) {
                for (Fact fact : notLinkedFacts) {
                    for (Planed plane : notLinkedPlans) {
                        if (checkEquals(fact, plane)) {
                            Link link = new Link();
                            link.setFactId(fact.getId());
                            link.setPlanId(plane.getId());
                            link.setSum(plane.getPlanSum());
                            plane.setPlanSumLinked(link.getSum());
                            fact.setFactSumLinked(link.getSum());
                            linksToCreate.add(link);
                            factsToUpdate.add(fact);
                            plansToUpdate.add(plane);
                            break;
                        }
                    }
                }
            }
            if (!linksToCreate.isEmpty()) linkRepository.saveAll(linksToCreate);
            if (!factsToUpdate.isEmpty()) factService.updateSetFact(factsToUpdate);
            if (!plansToUpdate.isEmpty()) planedService.updateSetPlaned(plansToUpdate);
            return generateResultMessage(linksToCreate);
        } catch (Exception e) {
            throw new EntityException(ErrorReason.LINKS_CREATION_FAILURE.getDescriprtion());
        }
    }

    private boolean checkEquals(Fact fact, Planed planed) {
        if (fact.getAgentCode().equals(planed.getAgentCode())) {
            if (fact.getOpCode().equals(planed.getOpCode())) {
                if (fact.getFactSum().equals(planed.getPlanSum())) {
                    return true;
                }
            }
        }
        return false;
    }

    private String generateResultMessage(Set<Link> links) {
        StringBuilder sb = new StringBuilder("Создано ссылок: " + links.size() + "\n");
        for (Link link : links) {
            sb.append(link.getPlanId());
            sb.append("<->");
            sb.append(link.getFactId());
            sb.append("\n");
        }
        return sb.toString();
    }
}
