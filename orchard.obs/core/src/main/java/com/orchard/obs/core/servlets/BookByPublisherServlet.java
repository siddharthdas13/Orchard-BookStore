package com.orchard.obs.core.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.google.gson.Gson;
import com.orchard.obs.core.models.Book;
import com.orchard.obs.core.services.SideNavigationServices;

@Component(service = {Servlet.class},
			property = {
						//"sling.servlet.resourceTypes=" + "wcm/foundation/components/page",
						//"sling.servlet.selectors=" + "sample",
						"sling.servlet.paths=/bin/BookByPublisherServlet",
		                "sling.servlet.extensions=json",
		                "sling.servlet.methods=GET"
		                })

public class BookByPublisherServlet extends SlingAllMethodsServlet {

	/**
	 * 
	 */
	@Reference
	SideNavigationServices sideNavigationServices;
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
	
		String publisher = request.getParameter("publisherName");
		
		List<Book> bookByPublisher = sideNavigationServices.getBookBasedOnPublisher("table", publisher);		
		String json = new Gson().toJson(bookByPublisher);
		response.getWriter().print(json);
	}
}
