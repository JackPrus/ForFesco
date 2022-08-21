package by.prus.forfesco.service;

import by.prus.forfesco.dao.FactRepository;
import by.prus.forfesco.model.entity.Fact;
import by.prus.forfesco.model.enums.ErrorReason;
import by.prus.forfesco.myexception.EntityException;
import by.prus.forfesco.service.interfaces.FactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Service
public class FactServiceImpl implements FactService {

    @Autowired
    FactRepository factRepository;

    @Override
    public List<Fact> findAll() {
        return factRepository.findAll();
    }

    @Override
    public List<Fact> findAllByFactSumLinked(BigDecimal sumLinked) {
        return factRepository.findAllByFactSumLinked(sumLinked);
    }

    @Override
    public void updateSetFact(Set<Fact> factToUpdate) {
        factRepository.saveAll(factToUpdate);
    }

    @Override
    public List<Fact> findByAgentAndOperation(String agent, String operation) {
        if (agent != null && operation != null) {
            if (operation.equals("") && !agent.equals("")) { return factRepository.findByAgentCode(agent); }
            if (!operation.equals("") && agent.equals("")) { return factRepository.findByOpCode(operation); }
            if (!agent.equals("") && !operation.equals("")) { return factRepository.findByAgentCodeAndOpCode(agent, operation);
            } else {
                throw new EntityException(ErrorReason.WRONG_DATA.getDescriprtion());
            }
        }
        return null;
    }
}
