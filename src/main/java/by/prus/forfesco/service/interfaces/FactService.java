package by.prus.forfesco.service.interfaces;

import by.prus.forfesco.model.entity.Fact;
import by.prus.forfesco.model.entity.Planed;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public interface FactService {
    List<Fact> findAll();
    List<Fact> findAllByFactSumLinked(BigDecimal sumLinked);
    void updateSetFact(Set<Fact> factToUpdate);
    List<Fact> findByAgentAndOperation(String agent, String operation);
}
