package by.prus.forfesco.service.interfaces;

import by.prus.forfesco.model.entity.Planed;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public interface PlanedService {
    List<Planed> findAll();
    List<Planed> findAllByPlanSumLinked(BigDecimal sumLinked);
    void updateSetPlaned(Set<Planed> planedToUpdate);
}
