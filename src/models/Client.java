package models;

import java.sql.Date;

public class Client {

  private String firstName;
  private String lastName;
  private Date birthDate;
  private String email;
  private String address;

  public Client(
    String firstName,
    String lastName,
    Date birthDate,
    String email,
    String address
  ) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.birthDate = birthDate;
    this.email = email;
    this.address = address;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Date getbirthDate() {
    return birthDate;
  }

  public void setbirthDate(Date birthDate) {
    this.birthDate = birthDate;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }
}
