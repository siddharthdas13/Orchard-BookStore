package com.orchard.obs.core.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.orchard.obs.Exceptions.serviceExceptions.BookServiceException;
import com.orchard.obs.core.services.BookService;

/**
 * @author Rushabh
 *
 */
@Component(
		service=Servlet.class,
		property={
				Constants.SERVICE_DESCRIPTION + "=BookServlet",
				"sling.servlet.paths=" + "/bin/obs/bookservlet",
				"sling.servlet.selectors=" + "book"
		}
)
public class BookServlet extends SlingAllMethodsServlet {

	private static final long serialVersionUID = 1L;

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Reference
	BookService bookService;
	
	@Override
	protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		
		String bookId = request.getParameter("bookId");
		String action = request.getParameter("action");
		
		try {
			if (action.equals("getbookdata")) {
				String customerId = request.getParameter("customerId");
				response.getWriter().println(new Gson().toJson(bookService.getBookDetails("bookworm", bookId, customerId)));
			}
			else if (action.equals("addtocart")) {
				String customerId = request.getParameter("customerId");
				response.getWriter().println(new Gson().toJson(bookService.addBookToCart("bookworm", bookId, customerId)));
			}
			else if (action.equals("buynow")) {
				response.getWriter().println("Buy Now");
			}
		} catch (BookServiceException e) {
			logger.info(e.getMessage());
		}
	}

}
