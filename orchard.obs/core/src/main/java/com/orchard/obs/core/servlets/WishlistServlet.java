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
import com.orchard.obs.Exceptions.serviceExceptions.WishlistServiceException;
import com.orchard.obs.core.services.WishlistService;

/**
 * @author Rushabh
 *
 */
@Component(
		service=Servlet.class,
		property={
				Constants.SERVICE_DESCRIPTION + "=WishlistServlet",
				"sling.servlet.paths=" + "/bin/obs/wishlistservlet",
				"sling.servlet.selectors=" + "wishlist"
		}
)
public class WishlistServlet extends SlingAllMethodsServlet {

	private static final long serialVersionUID = 1L;

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Reference
	WishlistService wishlistService;
	
	@Override
	protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		
		String bookId = request.getParameter("bookId");
		String customerId = request.getParameter("customerId");
		String action = request.getParameter("action");

		try {
			if (action.equals("getwishlistdata")) {
				response.getWriter().println(new Gson().toJson(wishlistService.getWishlistDetails("bookworm", customerId)));
			}
			else if (action.equals("addtocart")) {
				response.getWriter().println(wishlistService.addBookToCart("bookworm", bookId, customerId));
			}
			else if (action.equals("removeitem")) {
				response.getWriter().println(wishlistService.deleteWishlistItem("bookworm", bookId, customerId));
			}
		} catch (WishlistServiceException e) {
			response.getWriter().println(e.getCause());
		}
	}

}
