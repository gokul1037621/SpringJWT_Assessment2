package com.example.EcommerceJWT.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
user entity that is defined as a table in the postgresql database through the annotations
2 constructors are also created for the class. Class consists of columns(data members)
with one primary key having an auto generated value. class also has getters abd setters
in case of any updates made in db. JPA persistence helps to maintain data in db throughout the run
context.
 */

@Entity
@Data
@Table(name = "User table")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    @Column(name = "userId")
    private int id;

    @Column(name = "userName")
    private String userName;

    @Column(name = "userEmail")
    private String email;

    @Column(name = "userPassword")
    private String password1;

    @Column(name = "optionalPassword")
    private String password2;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password1;
    }

    public void setPassword(String password) {
        this.password1 = password;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }
}
