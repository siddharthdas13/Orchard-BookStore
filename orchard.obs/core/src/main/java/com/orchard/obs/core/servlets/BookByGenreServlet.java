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
						"sling.servlet.paths=/bin/BookByGenreServlet",
		                "sling.servlet.extensions=json",
		                "sling.servlet.methods=GET"
		                })

public class BookByGenreServlet extends SlingAllMethodsServlet {

	@Reference
	SideNavigationServices sideNavigationServices;
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
	
		String genre = request.getParameter("genreName");
		
		List<Book> bookByGenre = sideNavigationServices.getBookBasedOnGenre("table", genre);		
		String json = new Gson().toJson(bookByGenre);
		response.getWriter().print(json);
	}
}
