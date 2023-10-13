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
import jakarta.persistence.Version;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

@JmixEntity
@Table(name = "CF23_CHANGE", indexes = {
    @Index(name = "IDX_CF23_CHANGE_SITUATION_ALERT", columnList = "SITUATION_ALERT_ID")
})
@Entity(name = "cf23_Change")
public class Change
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
    
    @Column(name = "CHANGE_NO", length = 25)
    private String changeNo;
    
    @InstanceName
    @Column(name = "SUMMARY")
    @Lob
    private String summary;
    
    @Column(name = "SNOW_CHANGE_LINK")
    @Lob
    private String snowChangeLink;
    
    @Column(name = "IMPLEMENTED_ON")
    private LocalDate implementedOn;
    
    @OnDeleteInverse(DeletePolicy.CASCADE)
    @JoinColumn(name = "SITUATION_ALERT_ID", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private SituationAlert situationAlert;
    
    public SituationAlert getSituationAlert() {return situationAlert;}
    
    public void setSituationAlert(SituationAlert situationAlert) {this.situationAlert = situationAlert;}
    
    public LocalDate getImplementedOn() {return implementedOn;}
    
    public void setImplementedOn(LocalDate implementedOn) {this.implementedOn = implementedOn;}
    
    public String getSnowChangeLink() {return snowChangeLink;}
    
    public void setSnowChangeLink(String snowChangeLink) {this.snowChangeLink = snowChangeLink;}
    
    public String getSummary() {return summary;}
    
    public void setSummary(String summary) {this.summary = summary;}
    
    public String getChangeNo() {return changeNo;}
    
    public void setChangeNo(String changeNo) {this.changeNo = changeNo;}
    
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
}