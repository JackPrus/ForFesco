package by.prus.forfesco.dao;

import by.prus.forfesco.model.entity.Fact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface FactRepository extends JpaRepository<Fact, Long> {
    List<Fact> findAllByFactSumLinked(BigDecimal factSumLinked);
    List<Fact> findByAgentCode(String agentCode);
    List<Fact> findByOpCode(String operationCode);
    List<Fact> findByAgentCodeAndOpCode(String agentCode, String opCode);
}
