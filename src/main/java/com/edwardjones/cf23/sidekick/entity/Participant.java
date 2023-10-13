package com.edwardjones.cf23.sidekick.entity;

import io.jmix.core.DeletePolicy;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDeleteInverse;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

@JmixEntity
@Table(name = "CF23_PARTICIPANT", indexes = {
    @Index(name = "IDX_CF23_PARTICIPANT_SITUATION_ALERT", columnList = "SITUATION_ALERT_ID"),
    @Index(name = "IDX_CF23_PARTICIPANT_TEAM", columnList = "TEAM_ID")
})
@Entity(name = "cf23_Participant")
public class Participant
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
    
    @Column(name = "FIRST_NAME", length = 50)
    private String firstName;
    
    @Column(name = "LAST_NAME", length = 50)
    private String lastName;
    
    @InstanceName
    @Column(name = "PREFERRED_NAME", length = 100)
    private String preferredName;
    
    @Column(name = "PORJ", length = 10)
    private String porj;
    
    @Column(name = "TITLE", length = 50)
    private String title;
    
    @Column(name = "EMAIL_ADDRESS", length = 100)
    private String emailAddress;
    
    @Column(name = "PHONE_NO", length = 16)
    private String phoneNo;
    
    @Column(name = "LEADER")
    private Boolean leader;
    
    @OnDeleteInverse(DeletePolicy.CASCADE)
    @JoinColumn(name = "SITUATION_ALERT_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SituationAlert situationAlert;
    
    @OnDeleteInverse(DeletePolicy.CASCADE)
    @JoinColumn(name = "TEAM_ID", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Team team;
    
    @Composition
    @OneToMany(mappedBy = "participant")
    private List<Page> pages;
    
    public Boolean getLeader() {return leader;}
    
    public void setLeader(Boolean leader) {this.leader = leader;}
    
    public Team getTeam() {return team;}
    
    public void setTeam(Team team) {this.team = team;}
    
    public String getPhoneNo() {return phoneNo;}
    
    public void setPhoneNo(String phoneNo) {this.phoneNo = phoneNo;}
    
    public String getEmailAddress() {return emailAddress;}
    
    public void setEmailAddress(String emailAddress) {this.emailAddress = emailAddress;}
    
    public String getTitle() {return title;}
    
    public void setTitle(String title) {this.title = title;}
    
    public SituationAlert getSituationAlert() {return situationAlert;}
    
    public void setSituationAlert(SituationAlert situationAlert) {this.situationAlert = situationAlert;}
    
    public List<Page> getPages() {return pages;}
    
    public void setPages(List<Page> pages) {this.pages = pages;}
    
    public String getPorj() {return porj;}
    
    public void setPorj(String porj) {this.porj = porj;}
    
    public String getPreferredName() {return preferredName;}
    
    public void setPreferredName(String preferredName) {this.preferredName = preferredName;}
    
    public String getLastName() {return lastName;}
    
    public void setLastName(String lastName) {this.lastName = lastName;}
    
    public String getFirstName() {return firstName;}
    
    public void setFirstName(String firstName) {this.firstName = firstName;}
    
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