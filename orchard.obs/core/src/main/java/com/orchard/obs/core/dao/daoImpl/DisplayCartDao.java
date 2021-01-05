package com.orchard.obs.core.dao.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.commons.datasource.poolservice.DataSourcePool;
import com.orchard.obs.core.entity.MyProducts;

@Component(immediate =  true, service = DisplayCartDao.class)
public class DisplayCartDao {
	
	
	private Logger logger = LoggerFactory.getLogger(DisplayCartDao.class);
			
			@Reference
			DataSourcePool source;
			
			public List<MyProducts> getProducts(String dataSourceName,String customerId)
			{
				DataSource dataSource = null;
				Connection connection = null;
				Statement statement = null;
				ResultSet resultSet = null;
				List<MyProducts>myProducts=new ArrayList<MyProducts>();
				try {
					logger.error("Inside Connection, Source Is {}", source);
					dataSource = (DataSource) source.getDataSource(dataSourceName);
					connection = dataSource.getConnection();
					logger.info("Working : {}", connection);
					statement = connection.createStatement();
					resultSet = statement.executeQuery("Select * FROM cart INNER JOIN book on (book.bookId=cart.bookId) where customer_id="+"'"+customerId+"'");
					
					while (resultSet.next()) {
						//For each employee record-- create an Employee instance
						MyProducts myProducts2=new MyProducts();
						//Populate Employee object with data from MySQL
						myProducts2.setName(resultSet.getString(5));
						myProducts2.setPrice(resultSet.getDouble(12));
						myProducts2.setDiscount(resultSet.getDouble(13));
						myProducts2.setQuantity(resultSet.getInt(3));
						//Push the Employee Object to the list
						myProducts.add(myProducts2);
						logger.info("data : {}", myProducts2.getName()+myProducts2.getDiscount()+myProducts2.getPrice()+myProducts2.getQuantity());
						
					} 
					
					
					return myProducts;
				} catch (Exception e) {
					logger.error("Error Occured While Establishing The Connection : " + e);
				}
				return null;
			
			}
	}

