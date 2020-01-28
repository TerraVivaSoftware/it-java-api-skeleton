package com.ciandt.skeleton.core.domain;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * This class represents a post made by an {@link User} in the blog.
 *
 * @author mvidolin
 * @since Jul 29, 2019
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "post")
public class Post {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "POST_CD_POST", unique = true)
  private Long code;

  @Type(type = "org.hibernate.type.UUIDCharType")
  @Column(name = "POST_CD_UUID", unique = true, updatable = false)
  private UUID uuid;

  @OneToOne
  @JoinColumn(updatable = false)
  private User author;

  @Column(name = "POST_TX_TITLE")
  private String title;

  @Column(name = "POST_TX_CONTENT")
  private String content;

  @CreationTimestamp
  @Column(name = "POST_DT_CREATE", updatable = false)
  private LocalDateTime publishedAt;

  @UpdateTimestamp
  @Column(name = "POST_DT_UPDATE", updatable = false)
  private LocalDateTime editedAt;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  private Collection<Comment> comments;

  @PrePersist
  public void prePersist() {
    this.uuid = UUID.randomUUID();
  }

  /**
   * Updates the current Comment with the new values.
   */
  public void applyValues(final Post post) {
    this.setContent(post.getContent());
    this.setTitle(post.getTitle());
  }
}
