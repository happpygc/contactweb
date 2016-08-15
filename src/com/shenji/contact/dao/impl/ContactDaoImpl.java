package com.shenji.contact.dao.impl;



import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;





import org.dom4j.Element;

import com.shenji.contact.dao.ContactDao;
import com.shenji.contact.entity.Contact;
import com.shenji.contact.utils.XMLUtil;

public class ContactDaoImpl implements ContactDao{

	@Override
	public void addContact(Contact contact) {
		
		File file = new File("E:/contact.xml");
		Document doc = null;
		Element rootElem = null;
		if(!file.exists()){
			doc = DocumentHelper.createDocument();
//			创建根标签
			rootElem = doc.addElement("contactList");
		}else{
			//如果有xml文档就读取文件
			doc = XMLUtil.getDocument();
			rootElem = doc.getRootElement();
		}
		Element contactElem = rootElem.addElement("contact");
		
		String uuid = UUID.randomUUID().toString().replace("-", "");
		contactElem.addAttribute("id", uuid);
		contactElem.addElement("name").setText(contact.getName());
		contactElem.addElement("gender").setText(contact.getGender());
		contactElem.addElement("age").setText(contact.getAge()+"");
		contactElem.addElement("phone").setText(contact.getPhone());
		contactElem.addElement("email").setText(contact.getEmail());
		contactElem.addElement("qq").setText(contact.getQq());
		
		XMLUtil.write2xml(doc);
		
	}

	

	@Override
	public void updateContact(Contact c) {
		Document doc = XMLUtil.getDocument();
	Element contactElem = (Element)doc.selectNodes("//contact[@id'"+c.getId()+"']");
	
	}

	@Override
	public List<Contact> findAll() {
		
		Document document = XMLUtil.getDocument();
		List<Contact> list = new ArrayList<Contact>();
		List<Element> conList = document.selectNodes("//contact");
		for (Element e : conList) {
			Contact c = new Contact();
			c.setId(e.attributeValue("id"));
			c.setName(e.elementText("name"));
			c.setGender(e.elementText("gender"));
			c.setAge(Integer.parseInt(e.elementText("age")));
			c.setPhone(e.elementText("phone"));
			c.setEmail(e.elementText("email"));
			c.setQq(e.elementText("qq"));
			list.add(c);
		}
		return list;
	}

	@Override
	public Contact finaById(String id) {
		return null;
	}

	@Override
	public boolean checkContact(String name) {
		return false;
	}



	@Override
	public void delContact(String id) {
		
	}

}
