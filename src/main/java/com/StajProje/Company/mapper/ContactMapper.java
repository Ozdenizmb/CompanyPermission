package com.StajProje.Company.mapper;

import com.StajProje.Company.dto.ContactDto;
import com.StajProje.Company.model.Contact;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContactMapper extends BaseMapper<Contact, ContactDto> {



}
