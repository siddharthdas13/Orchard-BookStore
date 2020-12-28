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
import com.orchard.obs.core.util.DBUtil;

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
	
	@Reference
	DBUtil dbUtil;
	
	@Override
	protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		String customerId = request.getParameter("customerId");
		
		try {
			if(!request.getParameterMap().containsKey("bookId")) {
				response.getWriter().println(new Gson().toJson(cartService.getCartDetails("bookworm", customerId)));
			}
			else if(request.getParameterMap().containsKey("bookId") && request.getParameterMap().containsKey("quantity")){
				String bookId = request.getParameter("bookId");
				int cartQuantity = Integer.valueOf(request.getParameter("quantity")); 
				response.getWriter().println(cartService.updateCartDetails("bookworm", bookId, cartQuantity, customerId));
			}
			else if(request.getParameterMap().containsKey("bookId")){
				String bookId = request.getParameter("bookId");
				response.getWriter().println(cartService.deleteCartItem("bookworm", bookId, customerId));
			}
		} catch (CartServiceException e) {
			logger.info(e.getMessage());
		}
	}

}
