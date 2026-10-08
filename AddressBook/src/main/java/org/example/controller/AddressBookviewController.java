package org.example.controller;

import org.example.AddressBook;
import org.example.AddressBookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AddressBookviewController {
    private final AddressBookRepository addressBookRepository;
    public AddressBookviewController(AddressBookRepository addressBookRepository) {
        this.addressBookRepository = addressBookRepository;
    }

    @GetMapping("/addressbooks/{id}")
    public String showAddressBook(@PathVariable Integer id, Model model){
        AddressBook addressBook = addressBookRepository.findById(id).orElseThrow();
        model.addAttribute("addressBook", addressBook);
        return "addressbook";

    }
}
