package com.edwardjones.cf23.sidekick.entity;

import io.jmix.core.DeletePolicy;
import io.jmix.core.MetadataTools;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDeleteInverse;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.DependsOnProperties;
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
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

@JmixEntity
@Table(name = "CF23_SITUATION_ALERT", indexes = {
    @Index(name = "IDX_CF23_SITUATION_ALERT_PRODUCT", columnList = "PRODUCT_ID")
})
@Entity(name = "cf23_SituationAlert")
public class SituationAlert
{
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;
    
    @Column(name = "VERSION", nullable = false)
    @Version
    private Integer version;
    
    @CreatedBy
    @Column(name = "CREATED_BY")
    private String createdBy;
    
    @CreatedDate
    @Column(name = "CREATED_DATE")
    private OffsetDateTime createdDate;
    
    @LastModifiedBy
    @Column(name = "LAST_MODIFIED_BY")
    private String lastModifiedBy;
    
    @LastModifiedDate
    @Column(name = "LAST_MODIFIED_DATE")
    private OffsetDateTime lastModifiedDate;
    
    @Column(name = "NAME", length = 50)
    private String name;
    
    @Column(name = "DESCRIPTION")
    @Lob
    private String description;
    
    @Column(name = "STATUS")
    private String status;
    
    @OnDeleteInverse(DeletePolicy.CASCADE)
    @JoinColumn(name = "PRODUCT_ID", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Product product;
    
    @Column(name = "PROBLEM")
    @Lob
    private String problem;
    
    @Column(name = "REMEDY")
    @Lob
    private String remedy;
    
    @Column(name = "CAUSE")
    @Lob
    private String cause;
    
    @Column(name = "INCIDENT_NO", length = 50)
    private String incidentNo;
    
    @Column(name = "REPORTED_BY", length = 50)
    private String reportedBy;
    
    @Column(name = "REPORTED_ON")
    private LocalDateTime reportedOn;
    
    @Column(name = "BRIDGE_PHONE_NO", length = 16)
    private String bridgePhoneNo;
    
    @Column(name = "SERVICE_LEVEL")
    private Integer serviceLevel;
    
    @Composition
    @OneToMany(mappedBy = "situationAlert")
    private List<Participant> participants;
    
    @Composition
    @OneToMany(mappedBy = "situationAlert")
    private List<Change> changes;
    
    @Composition
    @OneToMany(mappedBy = "situationAlert")
    private List<Action> actions;
    
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "situationAlert")
    private Transcript transcript;
    
    public Transcript getTranscript() {return transcript;}
    
    public void setTranscript(Transcript transcript) {this.transcript = transcript;}
    
    public Integer getServiceLevel() {return serviceLevel;}
    
    public void setServiceLevel(Integer serviceLevel) {this.serviceLevel = serviceLevel;}
    
    public Product getProduct() {return product;}
    
    public void setProduct(Product product) {this.product = product;}
    
    public List<Action> getActions() {return actions;}
    
    public void setActions(List<Action> actions) {this.actions = actions;}
    
    public String getBridgePhoneNo() {return bridgePhoneNo;}
    
    public void setBridgePhoneNo(String bridgePhoneNo) {this.bridgePhoneNo = bridgePhoneNo;}
    
    public List<Change> getChanges() {return changes;}
    
    public void setChanges(List<Change> changes) {this.changes = changes;}
    
    public SituationAlertStatus getStatus() {return status == null ? null : SituationAlertStatus.fromId(status);}
    
    public void setStatus(SituationAlertStatus status) {this.status = status == null ? null : status.getId();}
    
    public List<Participant> getParticipants() {return participants;}
    
    public void setParticipants(List<Participant> participants) {this.participants = participants;}
    
    public String getIncidentNo() {return incidentNo;}
    
    public void setIncidentNo(String incidentNo) {this.incidentNo = incidentNo;}
    
    public String getCause() {return cause;}
    
    public void setCause(String cause) {this.cause = cause;}
    
    public String getRemedy() {return remedy;}
    
    public void setRemedy(String remedy) {this.remedy = remedy;}
    
    public String getProblem() {return problem;}
    
    public void setProblem(String problem) {this.problem = problem;}
    
    public LocalDateTime getReportedOn() {return reportedOn;}
    
    public void setReportedOn(LocalDateTime reportedOn) {this.reportedOn = reportedOn;}
    
    public String getReportedBy() {return reportedBy;}
    
    public void setReportedBy(String reportedBy) {this.reportedBy = reportedBy;}
    
    public String getDescription() {return description;}
    
    public void setDescription(String description) {this.description = description;}
    
    public String getName() {return name;}
    
    public void setName(String name) {this.name = name;}
    
    public OffsetDateTime getLastModifiedDate() {return lastModifiedDate;}
    
    public void setLastModifiedDate(OffsetDateTime lastModifiedDate) {this.lastModifiedDate = lastModifiedDate;}
    
    public String getLastModifiedBy() {return lastModifiedBy;}
    
    public void setLastModifiedBy(String lastModifiedBy) {this.lastModifiedBy = lastModifiedBy;}
    
    public OffsetDateTime getCreatedDate() {return createdDate;}
    
    public void setCreatedDate(OffsetDateTime createdDate) {this.createdDate = createdDate;}
    
    public String getCreatedBy() {return createdBy;}
    
    public void setCreatedBy(String createdBy) {this.createdBy = createdBy;}
    
    public Integer getVersion() {return version;}
    
    public void setVersion(Integer version) {this.version = version;}
    
    public UUID getId() {return id;}
    
    public void setId(UUID id) {this.id = id;}
    
    @InstanceName
    @DependsOnProperties({"incidentNo"})
    public String getInstanceName(MetadataTools metadataTools)
    {
        return metadataTools.format(incidentNo);
    }
}