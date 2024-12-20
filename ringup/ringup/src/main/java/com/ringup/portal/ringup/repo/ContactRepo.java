package com.ringup.portal.ringup.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ringup.portal.ringup.model.Contact;

@Repository
public interface ContactRepo extends JpaRepository<Contact, Integer>  {

}
