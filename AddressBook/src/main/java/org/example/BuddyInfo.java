package org.example;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class BuddyInfo {
    @Id
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
