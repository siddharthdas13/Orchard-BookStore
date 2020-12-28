/**
 * 
 */
package com.orchard.obs.core.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.orchard.obs.Exceptions.serviceExceptions.LoginServiceException;
import com.orchard.obs.core.services.LoginService;
import com.orchard.obs.core.util.DBUtil;

/**
 * @author Rushabh
 *
 */
@Component(
		service=Servlet.class,
		property={
				Constants.SERVICE_DESCRIPTION + "=LoginServlet",
				"sling.servlet.paths=" + "/bin/obs/loginservlet"
		}
)
public class LoginServlet extends SlingSafeMethodsServlet {

	private static final long serialVersionUID = 1L;

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Reference
	LoginService loginService;
	
	@Reference
	DBUtil dbUtil;
	
	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			String name = request.getParameter("name");
			String password = request.getParameter("password");			
			response.getWriter().println(new Gson().toJson(loginService.getCustomerDetails("bookworm", name, password)));
		} catch (LoginServiceException e) {
			// TODO Auto-generated catch block
			response.getWriter().println(e.getMessage());
		}
	}

}

