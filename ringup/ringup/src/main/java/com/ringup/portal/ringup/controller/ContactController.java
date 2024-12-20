package com.ringup.portal.ringup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ringup.portal.ringup.Exceptions.ResourceNotFoundException;
import com.ringup.portal.ringup.model.Contact;
import com.ringup.portal.ringup.repo.ContactRepo;

import jakarta.websocket.server.PathParam;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping(path = "api/v1/contact/")
public class ContactController {

	@Autowired
	ContactRepo contactRepository;

	@GetMapping(path = "/getContacts")
	public List<Contact> getContactDetails() {
		return contactRepository.findAll();
	}

	@PostMapping(path = "/addContact")
	public Contact saveContact(@RequestBody Contact contacts) {
		System.out.println("addcontacts" + contacts);
		return contactRepository.save(contacts);
	}

	@DeleteMapping(path = "/deleteContactById")
	public ResponseEntity<String> deleteContactById(@PathParam(value = "contactId") Integer contactId) {
		java.util.Optional<Contact> contanctObject = contactRepository.findById(contactId);
		if (contanctObject.isPresent()) {
			contactRepository.deleteById(contactId);
			return ResponseEntity.ok("Contact is deleted : " + contactId);
		}
		throw new ResourceNotFoundException("Contact not found with ID: " + contactId);

	}

	@GetMapping(path = "/getContactById")
	public ResponseEntity<Contact> getContactById(@PathParam(value = "contactId") Integer contactId) {
		java.util.Optional<Contact> contanctObject = contactRepository.findById(contactId);
		if (!contanctObject.isPresent()) {
			throw new ResourceNotFoundException("Contact not found with ID: " + contactId);
		}
		return ResponseEntity.ok(contanctObject.get());
	}

}
