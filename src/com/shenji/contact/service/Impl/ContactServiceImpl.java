package com.shenji.contact.service.Impl;


import java.util.List;

import com.shenji.contact.dao.ContactDao;
import com.shenji.contact.dao.impl.ContactDaoImpl;
import com.shenji.contact.entity.Contact;
import com.shenji.contact.service.ContactService;

public class ContactServiceImpl implements ContactService{
	
	ContactDao dao = new ContactDaoImpl();
	
	@Override
	public void addContact(Contact contact) {
		dao.addContact(contact);
	}

	@Override
	public void updateContact(Contact contact) {
		dao.updateContact(contact);
	}

	@Override
	public void deleteContact(String id) {
		dao.delContact(id);
	}

	@Override
	public List<Contact> findAll() {
		
		return dao.findAll();
	}

	@Override
	public Contact findById(String id) {
		
		return dao.finaById(id);
	}

}
