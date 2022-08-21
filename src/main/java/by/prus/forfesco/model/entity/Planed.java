package by.prus.forfesco.model.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Planed {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "Plan_Id")
    private Long id;
    @Column(name = "Plan_Agent_Code")
    private String agentCode;
    @Column(name = "Plan_OP_Code")
    private String opCode;
    @Column(name = "Plan_Sum")
    private BigDecimal planSum;
    @Column(name = "Plan_Sum_Linked")
    private BigDecimal planSumLinked;

    public Planed(){}

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

    public BigDecimal getPlanSum() {
        return planSum;
    }

    public void setPlanSum(BigDecimal planSum) {
        this.planSum = planSum;
    }

    public BigDecimal getPlanSumLinked() {
        return planSumLinked;
    }

    public void setPlanSumLinked(BigDecimal planSumLinked) {
        this.planSumLinked = planSumLinked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Planed planed = (Planed) o;
        return Objects.equals(id, planed.id) &&
                Objects.equals(agentCode, planed.agentCode) &&
                Objects.equals(opCode, planed.opCode) &&
                Objects.equals(planSum, planed.planSum) &&
                Objects.equals(planSumLinked, planed.planSumLinked);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, agentCode, opCode, planSum, planSumLinked);
    }
}
