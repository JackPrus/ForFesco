package by.prus.forfesco.dao;

import by.prus.forfesco.model.entity.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AgentRepostory extends JpaRepository<Agent, Long> {
    Optional<Agent> findByAgentCode(String agentCode);
}
