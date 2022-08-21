package by.prus.forfesco.dao;

import by.prus.forfesco.model.entity.Planed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface PlanedRepository extends JpaRepository<Planed, Long> {
    List<Planed> findAllByPlanSumLinked(BigDecimal planedSumLinked);
}
