package com.orchard.obs.core.servlets;

import java.io.IOException;


import javax.servlet.Servlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.gson.Gson;
import com.orchard.obs.core.entity.MyOrderDetail;
import com.orchard.obs.core.services.serviceImpl.MyOrderDetailService;
@Component(
service = { Servlet.class }, property = { " service.description=Servlet", "sling.servlet.paths=/bin/MyOrderDetailServlet",
"sling.servlet.methods=GET" })
public class MyOrderDetailServlet extends SlingAllMethodsServlet
{

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Reference
MyOrderDetailService orderService;

private static final Logger LOG = LoggerFactory.getLogger(MyOrderDetailServlet.class);


@Override
protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException
{
	LOG.info("inside My Order servlet");
try {
	LOG.info("inside try");
	//PlaceOrderService orderService=new PlaceOrderService();
	MyOrderDetail  myOrderDetail=orderService.myOrderDetail("bookworm",request.getParameter("order_id"));
	String json = new Gson().toJson(myOrderDetail);
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

