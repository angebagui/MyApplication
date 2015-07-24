package com.example.android.myapplication.ormlite.entity;

/**
 * Created by angebagui on 02/06/15.
 */

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "tb_user")
public class User extends BaseColumn {
    @DatabaseField(index = true, columnName = "username", unique = true, canBeNull = false)
    private String username;
    @DatabaseField(canBeNull = false, columnName = "password")
    private String password;
    @DatabaseField(columnName = "login_time")
    private String loginTime;

    @DatabaseField(columnName = "categorie")
    private String categorie;

    @DatabaseField(columnName = "name")
    private String name;

    @DatabaseField(columnName = "prenom")
    private String prenom;

    @DatabaseField(columnName = "dateNaissance")
    private String dateNaissance;

    @DatabaseField(columnName = "email")
    private String email;

    @DatabaseField(columnName = "adresse")
    private String adresse;


    @DatabaseField(columnName = "telephone")
    private String telephone;

    private long solde;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

    public String getCategorie() {
        return categorie;
    }

    public String getName() {
        return name;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }


    public long getSolde() {
        return solde;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }



    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("User{");
        sb.append("username='").append(username).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", loginTime='").append(loginTime).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
