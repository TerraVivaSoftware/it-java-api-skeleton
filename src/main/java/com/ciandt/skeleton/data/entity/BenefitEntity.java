package com.ciandt.skeleton.data.entity;

import com.ciandt.skeleton.core.domain.Benefit;
import java.util.ArrayList;
import java.util.Collection;
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
import org.springframework.beans.BeanUtils;

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

  @Column(name = "BENE_IN_ACTIVE")
  private boolean active;

  @Column(name = "BENE_DT_BEGIN")
  private Date beginAt;

  @Column(name = "BENE_DT_END")
  private Date endAt;

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

  public BenefitEntity(final Benefit benefit) {
    BeanUtils.copyProperties(this, benefit);
  }

  public static Benefit toDomain(final BenefitEntity entity) {
    Benefit benefit = BenefitFactory(entity.getType());
    return null;
  }

  public static Collection<Benefit> toDomain(Collection<BenefitEntity> entities) {
    Collection<Benefit> benefits = new ArrayList<>();
    for (BenefitEntity entity : entities) {
      benefits.add(entity.toDomain());
    }
    return benefits;
  }

  public Benefit toDomain() {
    return BenefitEntity.toDomain(this);
  }

}
