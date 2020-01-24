package com.ciandt.skeleton.core.domain;

import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;

/**
 * This class represents an {@link User}'s comment in a {@link Post}.
 *
 * @author mvidolin
 * @since Jul 29, 2019
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "comment")
public class Comment {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "COMM_CD_COMMENT", unique = true)
  private Long code;

  @Type(type = "org.hibernate.type.UUIDCharType")
  @Column(name = "COMM_CD_UUID", unique = true, updatable = false)
  private UUID uuid;

  @ManyToOne
  @JoinColumn(name = "USER_TX_LOGIN", referencedColumnName = "USER_TX_LOGIN", updatable = false)
  private User author;

  @CreationTimestamp
  @Column(name = "COMM_DT_CREATE", updatable = false)
  private LocalDateTime publishedAt;

  @Column(name = "COMM_TX_CONTENT")
  private String content;

  @Column(name = "POST_CD_POST")
  private Long postCode;

  @PrePersist
  public void prePersist() {
    this.uuid = UUID.randomUUID();
  }

  /**
   * Updates the current Comment with the new values.
   */
  public void applyValues(final Comment comment) {
    this.setContent(comment.getContent());
  }

}