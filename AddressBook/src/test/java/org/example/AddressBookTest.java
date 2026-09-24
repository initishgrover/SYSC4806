package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AddressBookTest {

    @Test
    void testAddBuddy() {
        AddressBook addressBook = new AddressBook();

        BuddyInfo buddy = new BuddyInfo("Nitish", "613-555-1234");

        addressBook.addBuddy(buddy);

        assertEquals(1, addressBook.getBuddies().size());
        assertEquals(buddy, addressBook.getBuddies().get(0));
    }

    @Test
    void testRemoveBuddy() {
        AddressBook addressBook = new AddressBook();

        BuddyInfo buddy = new BuddyInfo("Nitish", "613-555-1234");

        addressBook.addBuddy(buddy);
        addressBook.removeBuddy(buddy);

        assertEquals(0, addressBook.getBuddies().size());
    }
}