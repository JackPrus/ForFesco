package by.prus.forfesco.model.entity;

import javax.persistence.*;

@Entity
public class Agent {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "Agent_Code")
    private String agentCode;
    @Column(name = "Agent_Name")
    private String agentName;

    public Agent() {
    }

    public Agent(String agentCode, String agentName) {
        this.agentCode = agentCode;
        this.agentName = agentName;
    }

    public String getAgentCode() {
        return agentCode;
    }

    public void setAgentCode(String agentCode) {
        this.agentCode = agentCode;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }
}
