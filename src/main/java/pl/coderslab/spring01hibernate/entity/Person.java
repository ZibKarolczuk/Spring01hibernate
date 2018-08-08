package pl.coderslab.spring01hibernate.entity;

import javax.persistence.*;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String login;
    private String password;
    private String email;

    @OneToOne
    private PersonDetails personDetails;
    public Person() {
    }

    public Person(String login, String email, String password) {
        this.login = login;
        this.email = email;
        this.password = password;
    }

    public PersonDetails getPersonDetails() {
        return personDetails;
    }
    public void setPersonDetails(PersonDetails personDetails) {
        this.personDetails = personDetails;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}