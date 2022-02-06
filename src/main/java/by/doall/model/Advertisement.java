package by.doall.model;

import java.time.LocalDateTime;

public class Advertisement extends BaseEntity {

  private static final long serialVersionUID = -4451351625692036007L;

  private String title;
  private String description;
  private LocalDateTime createdAt;
  private long userId;

  public Advertisement() {}

  public Advertisement(
      long id, String title, String description, LocalDateTime createdAt, long userId) {
    super(id);
    this.title = title;
    this.description = description;
    this.createdAt = createdAt;
    this.userId = userId;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }
}
