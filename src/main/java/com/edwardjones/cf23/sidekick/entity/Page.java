package com.edwardjones.cf23.sidekick.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
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
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.UUID;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

@JmixEntity
@Table(name = "CF23_PAGE", indexes = {
    @Index(name = "IDX_CF23_PAGE_PARTICIPANT", columnList = "PARTICIPANT_ID")
})
@Entity(name = "cf23_Page")
public class Page
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
    
    @Column(name = "PHONE_NO", length = 16)
    private String phoneNo;
    
    @Column(name = "MESSAGE")
    @Lob
    private String message;
    
    @Column(name = "FIRST_PAGED_ON")
    private LocalDateTime firstPagedOn;
    
    @Column(name = "LAST_PAGED_ON")
    private LocalDateTime lastPagedOn;
    
    @Column(name = "RESPONDED_ON")
    private LocalDateTime respondedOn;
    
    @JoinColumn(name = "PARTICIPANT_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Participant participant;
    
    public String getMessage() {return message;}
    
    public void setMessage(String message) {this.message = message;}
    
    public Participant getParticipant() {return participant;}
    
    public void setParticipant(Participant participant) {this.participant = participant;}
    
    public LocalDateTime getRespondedOn() {return respondedOn;}
    
    public void setRespondedOn(LocalDateTime respondedOn) {this.respondedOn = respondedOn;}
    
    public LocalDateTime getLastPagedOn() {return lastPagedOn;}
    
    public void setLastPagedOn(LocalDateTime lastPagedOn) {this.lastPagedOn = lastPagedOn;}
    
    public LocalDateTime getFirstPagedOn() {return firstPagedOn;}
    
    public void setFirstPagedOn(LocalDateTime firstPagedOn) {this.firstPagedOn = firstPagedOn;}
    
    public String getPhoneNo() {return phoneNo;}
    
    public void setPhoneNo(String phoneNo) {this.phoneNo = phoneNo;}
    
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