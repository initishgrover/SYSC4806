package org.example;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class AddressBook {

    @Id
    private Integer id;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<BuddyInfo> buddies;
    public AddressBook(){
        buddies = new ArrayList<>();
    }
    public AddressBook(Integer id){
        this.id = id;
        buddies = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public void addBuddy(BuddyInfo buddy){
        buddies.add(buddy);
    }

    public void removeBuddy(BuddyInfo buddy){
        buddies.remove(buddy);
    }
    public List<BuddyInfo> getBuddies(){
        return buddies;
    }

    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        BuddyInfo buddy1 = new BuddyInfo("Nitish", "11223344");
        BuddyInfo buddy2 = new BuddyInfo("chang", "55667788");

        addressBook.addBuddy(buddy1);
        addressBook.addBuddy(buddy2);

        addressBook.removeBuddy(buddy1);

        System.out.println(addressBook.getBuddies());
    }
}

