package by.doall.model;

public class User extends BaseEntity {

  private static final long serialVersionUID = -2270576186344836102L;

  private String username;
  private String lastname;
  private String firstname;
  private Role role;

  public User() {}

  public User(long id, String username, String lastname, String firstname, Role role) {
    super(id);
    this.username = username;
    this.lastname = lastname;
    this.firstname = firstname;
    this.role = role;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }
}
