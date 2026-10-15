package org.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AddressBookHttpTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testCreateAddressBook() {
        ResponseEntity<AddressBook> response = restTemplate.postForEntity(
                "http://localhost:" + port + "/api/addressbooks",
                null,
                AddressBook.class
        );

        assertEquals(200, response.getStatusCode().value());
        assertNotNull(response.getBody());
        assertNotNull(response.getBody().getId());
    }


    @Test
    void testCreateBuddy() {
        BuddyInfo buddy = new BuddyInfo(
                "Nitish",
                "613-555-1234",
                "Ottawa, ON"
        );

        ResponseEntity<BuddyInfo> response = restTemplate.postForEntity(
                "http://localhost:" + port + "/api/buddies",
                buddy,
                BuddyInfo.class
        );

        assertEquals(200, response.getStatusCode().value());
        assertNotNull(response.getBody());
        assertNotNull(response.getBody().getId());
        assertEquals("Nitish", response.getBody().getName());
        assertEquals("613-555-1234", response.getBody().getPhoneNumber());
        assertEquals("Ottawa, ON", response.getBody().getAddress());
    }
}