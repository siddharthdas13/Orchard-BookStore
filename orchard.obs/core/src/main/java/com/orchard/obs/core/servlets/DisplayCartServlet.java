package com.orchard.obs.core.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.Servlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.gson.Gson;
import com.orchard.obs.core.entity.MyProducts;
import com.orchard.obs.core.services.serviceImpl.DisplayCartService;

@Component(
service = { Servlet.class }, property = { " service.description=Servlet", "sling.servlet.paths=/bin/DisplayCartServlet",
"sling.servlet.methods=GET" })
public class DisplayCartServlet extends SlingAllMethodsServlet
{

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Reference
DisplayCartService orderService;

private static final Logger LOG = LoggerFactory.getLogger(DisplayCartServlet.class);


@Override
protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException
{
	LOG.info("inside cart servlet");
try {
	LOG.info("inside try");
	//PlaceOrderService orderService=new PlaceOrderService();
	List<MyProducts> products=orderService.getProducts("bookworm", "ABC");
	String json = new Gson().toJson(products);
	LOG.info("json {} :" ,json);
	response.getWriter().print(json);
}
catch (IOException e) {
	// TODO Auto-generated catch block
	LOG.info("inside catch");
	LOG.info(e.getMessage());
	response.getWriter().println(e.getMessage());
}
}
}
