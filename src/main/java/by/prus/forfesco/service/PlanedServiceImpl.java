package by.prus.forfesco.service;

import by.prus.forfesco.dao.PlanedRepository;
import by.prus.forfesco.model.entity.Planed;
import by.prus.forfesco.service.interfaces.PlanedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Service
public class PlanedServiceImpl implements PlanedService {

    @Autowired
    PlanedRepository planedRepository;

    @Override
    public List<Planed> findAll() {
        return planedRepository.findAll();
    }

    @Override
    public List<Planed> findAllByPlanSumLinked(BigDecimal sumLinked) {
        return planedRepository.findAllByPlanSumLinked(sumLinked);
    }

    @Override
    public void updateSetPlaned(Set<Planed> planedToUpdate) {
        planedRepository.saveAll(planedToUpdate);
    }
}
