package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuddyInfoTest {

    @Test
    void testBuddyinfo() {
        BuddyInfo buddy = new BuddyInfo("dang", "222555");
        assertEquals("222555", buddy.getPhoneNumber());
        assertEquals("dang", buddy.getName());
    }

    @Test
    void testBuddyAddress() {
        BuddyInfo buddy = new BuddyInfo("dang", "222555", "Ottawa, ON");

        assertEquals("dang", buddy.getName());
        assertEquals("222555", buddy.getPhoneNumber());
        assertEquals("Ottawa, ON", buddy.getAddress());

        buddy.setAddress("Toronto, ON");
        assertEquals("Toronto, ON", buddy.getAddress());
    }

    @Test
    void testToString() {
        BuddyInfo buddy = new BuddyInfo("cass", "2225");
        assertEquals("cass-2225-null", buddy.toString());
    }
}