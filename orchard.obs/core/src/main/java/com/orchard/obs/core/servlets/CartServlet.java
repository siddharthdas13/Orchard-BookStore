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
import com.orchard.obs.Exceptions.serviceExceptions.CartServiceException;
import com.orchard.obs.core.services.CartService;

/**
 * @author Rushabh
 *
 */
@Component(
		service=Servlet.class,
		property={
				Constants.SERVICE_DESCRIPTION + "=CartServlet",
				"sling.servlet.paths=" + "/bin/obs/cartservlet",
				"sling.servlet.selectors=" + "cart"
		}
)
public class CartServlet extends SlingAllMethodsServlet {

	private static final long serialVersionUID = 1L;

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Reference
	CartService cartService;
	
	@Override
	protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		
		String customerId = request.getParameter("customerId");
		String action = request.getParameter("action");
		
		try {
			if(action.equals("getcartdata")) {
				response.getWriter().println(new Gson().toJson(cartService.getCartDetails("bookworm", customerId)));
			}
			else if(action.equals("updatecartdata")){
				String bookId = request.getParameter("bookId");
				int cartQuantity = Integer.valueOf(request.getParameter("quantity")); 
				response.getWriter().println(cartService.updateCartDetails("bookworm", bookId, cartQuantity, customerId));
			}
			else if (action.equals("addtowishlist")) {
				String bookId = request.getParameter("bookId");
				response.getWriter().println(cartService.addBookToWishlist("bookworm", bookId, customerId));
			}
			else if(action.equals("removecartitem")){
				String bookId = request.getParameter("bookId");
				response.getWriter().println(cartService.deleteCartItem("bookworm", bookId, customerId));
			}
		} catch (CartServiceException e) {
			response.getWriter().println(e.getCause());
		}
	}

}
