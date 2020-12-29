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

import com.orchard.obs.core.entity.Customer;
import com.orchard.obs.core.services.serviceImpl.OrderConfirmationService;
	
	

	@Component(
	service = { Servlet.class }, property = { " service.description=Servlet", "sling.servlet.paths=/bin/OrderConfirmationServlet",
	"sling.servlet.methods=GET" })
	public class OrderConfirmationServlet extends SlingAllMethodsServlet
	{

	/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	@Reference
	OrderConfirmationService orderService;

	private static final Logger LOG = LoggerFactory.getLogger(OrderConfirmationServlet.class);


	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException
	{
		LOG.info("inside servlet");
		
		/*	DataSource dataSource = null;
			Connection connection = null;
			Statement statement = null;
			ResultSet resultSet = null;
			Address address2=null;
			
				logger.error("Inside Connection, Source Is {}", source);
				try {
					dataSource = (DataSource) source.getDataSource("emp");
				
					connection = dataSource.getConnection();
					logger.info("Working : ", connection);
					statement = connection.createStatement();
					resultSet = statement.executeQuery("Select * FROM register ");
					logger.info("stmt : {}", "stmt");
					while (resultSet.next()) {
						//For each employee record-- create an Employee instance
						Student student =new Student();

						//Populate Employee object with data from MySQL
						logger.info("result : {}", "result");
						student.setName(resultSet.getString(1)); 
						
						student.setMail(resultSet.getString(3));
						//Push the Employee Object to the list
						logger.info("pin : {}", student.getName());
						logger.info("pin : {}", student.getMail());
				
				} 
				}catch (SQLException | DataSourceNotFoundException e) {
					// TODO Auto-generated catch block
					logger.info("catch : ", e.getMessage());
				}
				
			*/
		
		try {
			LOG.info("inside try");
			//PlaceOrderService orderService=new PlaceOrderService();
			Customer customer=orderService.getCustomer("bookworm", "ABC");
			String json = new Gson().toJson(customer);
			response.getWriter().print(json);
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			LOG.info("inside catch");
			LOG.info(e.getMessage());
			response.getWriter().println(e.getMessage());
		}
	//PlaceOrderService orderService=new PlaceOrderService();
	}
	}

