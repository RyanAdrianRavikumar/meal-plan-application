package com.mealplan.restaurant.entity;

import jakarta.persistence.*;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.Base64;

@Entity
@Table(name = "restaurant")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "owner_name")
    private String ownerName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Lob
    @Column(name = "image")
    private Blob image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImage() {
        if(image != null){
            try{
                int blobLength = (int) image.length();
                byte[] blobAsBytes = image.getBytes(1, blobLength);
                return Base64.getEncoder().encodeToString(blobAsBytes);
            } catch (SQLException ex){
                ex.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public void setImage(Blob image) {
        this.image = image;
    }
}
