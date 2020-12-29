package com.orchard.obs.core.dao.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.commons.datasource.poolservice.DataSourcePool;
import com.orchard.obs.core.entity.Customer;


@Component(immediate =  true, service = OrderConfirmationDao.class)
public class OrderConfirmationDao {
	
	
	private Logger logger = LoggerFactory.getLogger(OrderConfirmationDao.class);
			
			@Reference
			DataSourcePool source;
			
			public Customer getCustomer(String dataSourceName,String customerId)
			{
				DataSource dataSource = null;
				Connection connection = null;
				Statement statement = null;
				ResultSet resultSet = null;
				Customer customer=null;
				try {
					logger.error("Inside Connection, Source Is {}", source);
					dataSource = (DataSource) source.getDataSource(dataSourceName);
					connection = dataSource.getConnection();
					logger.info("Working : {}", connection);
					statement = connection.createStatement();
					resultSet = statement.executeQuery("Select * FROM customer where customer_id="+"'"+customerId+"'");
					
					while (resultSet.next()) {
						//For each employee record-- create an Employee instance
						customer= new Customer(resultSet.getString(3),resultSet.getString(7),resultSet.getString(8),resultSet.getString(12),resultSet.getString(11),resultSet.getString(9),resultSet.getString(10));
						//Populate Employee object with data from MySQL
						//Push the Employee Object to the list
						
					} 
					
					
					return customer;
				} catch (Exception e) {
					logger.error("Error Occured While Establishing The Connection : " + e);
				}
				return null;
			
			}
	}
