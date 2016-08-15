package com.shenji.contact.dao;

import java.util.List;

import com.shenji.contact.entity.Contact;

public interface ContactDao {

	
	public void addContact(Contact c);	
		
	public void delContact(String id);
	
	public void updateContact(Contact c);
	
	public List<Contact>  findAll();
	
	public Contact finaById(String Id);
	
	public boolean checkContact(String name);
}
