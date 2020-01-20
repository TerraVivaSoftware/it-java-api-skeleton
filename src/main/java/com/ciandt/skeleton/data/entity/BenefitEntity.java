package com.ciandt.skeleton.data.entity;

import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

@Data
@NoArgsConstructor
@Entity
@Table(name = "benefit")
public class BenefitEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "BENE_CD_BENEFIT", unique = true)
  private Long code;

  @Type(type="org.hibernate.type.UUIDCharType")
  @Column(name = "BENE_CD_UUID", unique = true, updatable = false)
  private UUID uuid;

  @Column(name = "BENE_NM_BENEFIT")
  private String name;

  @Column(name = "BENE_QT_QUANTITY")
  private int amount;

  @Column(name = "BENE_VL_VALUE")
  private double value;

  @Column(name = "BENE_SG_TYPE")
  private String type;

  @CreationTimestamp
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "BENE_DT_CREATION", updatable = false)
  private Date createdAt;

  @UpdateTimestamp
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "BENE_DT_UPDATE", updatable = false)
  private Date updatedAt;

  @PrePersist
  public void prePersist() {
    this.uuid = UUID.randomUUID();
  }

}
