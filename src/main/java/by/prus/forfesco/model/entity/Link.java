package by.prus.forfesco.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Link implements Serializable {
    @Id
    @Column(name = "Link_Plan_Id")
    private Long planId;
    @Column(name = "Link_Fact_Id")
    private Long factId;
    @Column(name = "Link_Sum")
    private BigDecimal sum;

    public Link() { }

    public Long getPlanId() {
        return planId;
    }

    public void setPlanId(Long planId) {
        this.planId = planId;
    }

    public Long getFactId() {
        return factId;
    }

    public void setFactId(Long factId) {
        this.factId = factId;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Link link = (Link) o;
        return Objects.equals(planId, link.planId) &&
                Objects.equals(factId, link.factId) &&
                Objects.equals(sum, link.sum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(planId, factId, sum);
    }
}
