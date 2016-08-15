package com.shenji.contact.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shenji.contact.entity.Contact;
import com.shenji.contact.service.ContactService;
import com.shenji.contact.service.Impl.ContactServiceImpl;

public class ListContactServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.从xml中拿到联系人数据
		ContactService service= new ContactServiceImpl();
		List<Contact> list = service.findAll();
		System.out.println(list);
		//2.把结果数据保存到域对象中
		request.setAttribute("contacts", list);
		//跳转到JSP页面
		request.getRequestDispatcher("/listContact.jsp").forward(request, response);
		
		
		
	
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
		
	}

}
