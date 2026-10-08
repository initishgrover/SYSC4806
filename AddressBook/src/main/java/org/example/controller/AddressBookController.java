package org.example.controller;

import org.example.AddressBook;
import org.example.BuddyInfo;
import org.example.BuddyInfoRepository;
import org.example.AddressBookRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AddressBookController {

    private final AddressBookRepository addressBookRepository;
    private final BuddyInfoRepository buddyInfoRepository;

    public AddressBookController(AddressBookRepository addressBookRepository, BuddyInfoRepository buddyInfoRepository) {
        this.addressBookRepository = addressBookRepository;
        this.buddyInfoRepository = buddyInfoRepository;
    }

    @PostMapping("/addressbooks")
    public AddressBook createAddressBook(){
        AddressBook addressBook = new AddressBook();
        return addressBookRepository.save(addressBook);
    }

    @PostMapping("/buddies")
    public BuddyInfo createBuddy(@RequestBody BuddyInfo buddyInfo){
        return buddyInfoRepository.save(buddyInfo);
    }

    @PostMapping("/addressbooks/{addressBookId}/buddies/{buddyId}")
    public AddressBook addBuddyToAddressBook(@PathVariable Integer addressBookId, @PathVariable Integer buddyId) {
        AddressBook addressBook = addressBookRepository.findById(addressBookId).orElseThrow();


        BuddyInfo buddy = buddyInfoRepository.findById(buddyId).orElseThrow();

        addressBook.addBuddy(buddy);

        return addressBookRepository.save(addressBook);
    }
}
