package com.edwardjones.cf23.sidekick.entity;

import io.jmix.core.DeletePolicy;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDeleteInverse;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.UUID;

@JmixEntity
@Table(name = "CF23_ACTION", indexes = {
    @Index(name = "IDX_CF23_ACTION_SITUATION_ALERT", columnList = "SITUATION_ALERT_ID")
})
@Entity(name = "cf23_Action")
public class Action
{
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;
    
    @InstanceName
    @Column(name = "NAME", length = 50)
    private String name;
    
    @Column(name = "DESCRIPTION")
    @Lob
    private String description;
    
    @Column(name = "ACTION_RESULT")
    private String result;
    
    @Column(name = "PRIORITY")
    private Integer priority;
    
    @OnDeleteInverse(DeletePolicy.CASCADE)
    @JoinColumn(name = "SITUATION_ALERT_ID", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private SituationAlert situationAlert;
    
    public Integer getPriority() {return priority;}
    
    public void setPriority(Integer priority) {this.priority = priority;}
    
    public SituationAlert getSituationAlert() {return situationAlert;}
    
    public void setSituationAlert(SituationAlert situationAlert) {this.situationAlert = situationAlert;}
    
    public ActionResult getResult() {return result == null ? null : ActionResult.fromId(result);}
    
    public void setResult(ActionResult result) {this.result = result == null ? null : result.getId();}
    
    public String getDescription() {return description;}
    
    public void setDescription(String description) {this.description = description;}
    
    public String getName() {return name;}
    
    public void setName(String name) {this.name = name;}
    
    public UUID getId() {return id;}
    
    public void setId(UUID id) {this.id = id;}
}