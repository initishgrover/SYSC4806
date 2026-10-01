package org.example;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JPATest {



    @Autowired
    private AddressBookRepository addressBookRepository;

    @Test
    void performJPA() {

        // Creating buddy objects
        BuddyInfo buddy1 = new BuddyInfo("Nitish", "11223344");
        BuddyInfo buddy2 = new BuddyInfo("chang", "55667788");


        AddressBook addressBook = new AddressBook();

        addressBook.addBuddy(buddy1);
        addressBook.addBuddy(buddy2);
        addressBookRepository.save(addressBook);

        System.out.println("List of address books\n----------------");

        Iterable<AddressBook> results = addressBookRepository.findAll();

        for (AddressBook a : results) {
            System.out.println("AddressBook id =" + a.getId());
            for(BuddyInfo b: a.getBuddies()) {
                System.out.println(" " + b.getName() + "id= "+ b.getId() + "phone= " +b.getPhoneNumber() + ")");
            }

        }
    }
}
