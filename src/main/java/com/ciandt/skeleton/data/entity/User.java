package com.ciandt.skeleton.data.entity;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

/**
 * This class represents a blog's user.
 * @author mvidolin
 * @since Jul 29, 2019
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {

  @Id
  @Column(name = "USER_TX_LOGIN")
  private String login;

  @Type(type="org.hibernate.type.UUIDCharType")
  @Column(name = "USER_CD_UUID", unique = true, updatable = false)
  private UUID uuid;

  @Column(name = "USER_TX_NAME")
  private String name;

  @Column(name = "USER_TX_EMAIL")
  private String email;

}