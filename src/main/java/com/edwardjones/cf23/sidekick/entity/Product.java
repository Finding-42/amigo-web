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
import jakarta.persistence.Lob;
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
@Table(name = "CF23_PRODUCT", indexes = {
    @Index(name = "IDX_CF23_PRODUCT_PORTFOLIO", columnList = "PORTFOLIO_ID"),
    @Index(name = "IDX_CF23_PRODUCT_TEAM", columnList = "TEAM_ID")
})
@Entity(name = "cf23_Product")
public class Product
{
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;
    
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
    
    @Column(name = "VERSION", nullable = false)
    @Version
    private Integer version;
    
    @InstanceName
    @Column(name = "NAME", length = 50)
    private String name;
    
    @Column(name = "DESCRIPTION")
    @Lob
    private String description;
    
    @Column(name = "OWNER_NAME", length = 100)
    private String ownerName;
    
    @Column(name = "OWNER_PORJ", length = 10)
    private String ownerPorj;
    
    @OnDeleteInverse(DeletePolicy.CASCADE)
    @JoinColumn(name = "PORTFOLIO_ID", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Portfolio portfolio;
    
    @JoinColumn(name = "TEAM_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Team team;
    
    @Composition
    @OneToMany(mappedBy = "product")
    private List<SituationAlert> situationAlert;
    
    public List<SituationAlert> getSituationAlert() {return situationAlert;}
    
    public void setSituationAlert(List<SituationAlert> situationAlert) {this.situationAlert = situationAlert;}
    
    public Team getTeam() {return team;}
    
    public void setTeam(Team team) {this.team = team;}
    
    public String getOwnerPorj() {return ownerPorj;}
    
    public void setOwnerPorj(String ownerPorj) {this.ownerPorj = ownerPorj;}
    
    public String getOwnerName() {return ownerName;}
    
    public void setOwnerName(String ownerName) {this.ownerName = ownerName;}
    
    public String getDescription() {return description;}
    
    public void setDescription(String description) {this.description = description;}
    
    public String getName() {return name;}
    
    public void setName(String name) {this.name = name;}
    
    public Portfolio getPortfolio() {return portfolio;}
    
    public void setPortfolio(Portfolio portfolio) {this.portfolio = portfolio;}
    
    public Integer getVersion() {return version;}
    
    public void setVersion(Integer version) {this.version = version;}
    
    public OffsetDateTime getLastModifiedDate() {return lastModifiedDate;}
    
    public void setLastModifiedDate(OffsetDateTime lastModifiedDate) {this.lastModifiedDate = lastModifiedDate;}
    
    public String getLastModifiedBy() {return lastModifiedBy;}
    
    public void setLastModifiedBy(String lastModifiedBy) {this.lastModifiedBy = lastModifiedBy;}
    
    public OffsetDateTime getCreatedDate() {return createdDate;}
    
    public void setCreatedDate(OffsetDateTime createdDate) {this.createdDate = createdDate;}
    
    public String getCreatedBy() {return createdBy;}
    
    public void setCreatedBy(String createdBy) {this.createdBy = createdBy;}
    
    public UUID getId() {return id;}
    
    public void setId(UUID id) {this.id = id;}
}