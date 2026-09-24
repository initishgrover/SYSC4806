package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class BuddyInfoTest {
    @Test
    void testBuddyinfo(){
        BuddyInfo buddy = new BuddyInfo("dang", "222555");
        assertEquals(buddy.getPhoneNumber(), "222555");
        assertEquals("dang", buddy.getName());
    }
    @Test
    void testToString(){
        BuddyInfo buddy = new BuddyInfo("cass", "2225");
        assertEquals("cass-2225", buddy.toString());
    }
}
