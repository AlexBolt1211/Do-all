package by.doall.model;

public class Advertisement extends BaseEntity {

  private static final long serialVersionUID = -4451351625692036007L;

  private String title;
  private String content;
  private String created;
  private long userid;

  public Advertisement(long id, String title, String content, String created, long userid) {
    super(id);
    this.title = title;
    this.content = content;
    this.created = created;
    this.userid = userid;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getCreated() {
    return created;
  }

  public void setCreated(String created) {
    this.created = created;
  }

  public long getUserid() {
    return userid;
  }

  public void setUserid(long userid) {
    this.userid = userid;
  }
}
