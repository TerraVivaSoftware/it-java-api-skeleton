package com.ciandt.skeleton.web.rest.v1.resource;

import java.util.Date;
import java.util.UUID;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommentGetResource {
  private UUID uuid;
  private UserResource author;
  private Date publishedAt;
  private String content;
}
