package me.wonwoo;

import java.util.Objects;

/**
 * Created by wonwoo on 2016. 10. 25..
 */
public class Account {
  private Long id;
  private String name;
  private String email;

  public Account(Long id, String name, String email) {
    this.id = id;
    this.name = name;
    this.email = email;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Account)) return false;
    Account account = (Account) o;
    return Objects.equals(id, account.id) &&
      Objects.equals(name, account.name) &&
      Objects.equals(email, account.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, email);
  }
}
