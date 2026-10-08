package org.example;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BuddyInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String phoneNumber;

    public BuddyInfo(String name, String phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
    public BuddyInfo(){

    }
    public Integer getId(){
        return id;
    }
    public void setId(Integer id){
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public String getName(){
        return name;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }

    @Override
    public String toString(){
        return name + "-" + phoneNumber;
    }
}
