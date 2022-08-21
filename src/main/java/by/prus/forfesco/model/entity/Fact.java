package by.prus.forfesco.model.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Fact {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "Fact_Id")
    private Long id;
    @Column(name = "Fact_Agent_code")
    private String agentCode;
    @Column(name = "Fact_Op_Code")
    private String opCode;
    @Column(name = "Fact_Sum")
    private BigDecimal factSum;
    @Column(name = "Fact_Sum_Linked")
    private BigDecimal factSumLinked;

    public Fact() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAgentCode() {
        return agentCode;
    }

    public void setAgentCode(String agentCode) {
        this.agentCode = agentCode;
    }

    public String getOpCode() {
        return opCode;
    }

    public void setOpCode(String opCode) {
        this.opCode = opCode;
    }

    public BigDecimal getFactSum() {
        return factSum;
    }

    public void setFactSum(BigDecimal factSum) {
        this.factSum = factSum;
    }

    public BigDecimal getFactSumLinked() {
        return factSumLinked;
    }

    public void setFactSumLinked(BigDecimal factSumLinked) {
        this.factSumLinked = factSumLinked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fact fact = (Fact) o;
        return Objects.equals(id, fact.id) &&
                Objects.equals(agentCode, fact.agentCode) &&
                Objects.equals(opCode, fact.opCode) &&
                Objects.equals(factSum, fact.factSum) &&
                Objects.equals(factSumLinked, fact.factSumLinked);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, agentCode, opCode, factSum, factSumLinked);
    }
}
