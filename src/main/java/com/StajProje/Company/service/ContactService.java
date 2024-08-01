package com.StajProje.Company.service;

import com.StajProje.Company.dto.ContactCreateDto;
import com.StajProje.Company.dto.ContactDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface ContactService {

    UUID createContact(ContactCreateDto contactCreateDto);
    ContactDto getContactById(UUID id);
    Page<ContactDto> getAllContacts(Pageable pageable);
    Boolean deleteContactById(UUID id);

}
