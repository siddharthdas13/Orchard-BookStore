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
import com.orchard.obs.Exceptions.serviceExceptions.LoginServiceException;
import com.orchard.obs.core.services.LoginService;

/**
 * @author Rushabh
 *
 */
@Component(
		service=Servlet.class,
		property={
				Constants.SERVICE_DESCRIPTION + "=DemoServlet",
				"sling.servlet.paths=" + "/bin/obs/demoservlet",
				"sling.servlet.selectors=" + "demo"
		}
)
public class DemoServlet extends SlingAllMethodsServlet {

	private static final long serialVersionUID = 1L;

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Reference
	LoginService loginService;
	
	@Override
	protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");	
		
		try {
			response.getWriter().println(new Gson().toJson(loginService.getCustomerDetails("bookworm", name, password)));
		} catch (LoginServiceException | IOException e) {
			// TODO Auto-generated catch block
			response.getWriter().println(e.getMessage());
		}

//		try {
			
//			response.getWriter().println(name + "  " + password);
//			response.getWriter().println(new Gson().toJson(loginService.getCustomerDetails("bookworm", name, password)));
//		} catch (LoginServiceException e) {
//			// TODO Auto-generated catch block
//			response.getWriter().println(e.getMessage());
//		}
	}

}
