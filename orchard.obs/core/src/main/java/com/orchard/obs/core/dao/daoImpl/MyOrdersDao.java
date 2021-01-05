package com.orchard.obs.core.dao.daoImpl;
/*
/*
 * 
 */
/*
 @author Kirti
 */
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
import com.orchard.obs.core.entity.MyOrders;
import com.orchard.obs.core.entity.MyProducts;


@Component(immediate =  true, service = MyOrdersDao.class)
public class MyOrdersDao {
	
	
	private Logger logger = LoggerFactory.getLogger(MyOrdersDao.class);
			
			@Reference
			DataSourcePool source;
			
			public List<MyOrders> getMyOrders(String dataSourceName,String customerId)
			{
				DataSource dataSource = null;
				Connection connection = null;
				Statement statement = null;
				ResultSet resultSet = null;
				List<MyOrders>myOrders=new ArrayList<MyOrders>();
				try {
					logger.error("Inside Connection, Source Is {}", source);
					dataSource = (DataSource) source.getDataSource(dataSourceName);
					connection = dataSource.getConnection();
					logger.info("Working : {}", connection);
					statement = connection.createStatement();
					resultSet = statement.executeQuery("Select * FROM Orders where customer_id="+"'"+customerId+"'");
					
					while (resultSet.next()) {
						Statement stmt=connection.createStatement();
						MyOrders orders=new MyOrders();
						orders.setMyOrderNo(resultSet.getInt("order_id"));
						logger.info("order : {}",orders.getMyOrderNo());
							ResultSet rs = stmt.executeQuery("Select * FROM order_detail INNER JOIN book on (book.bookId=order_detail.bookId) where order_id="+orders.getMyOrderNo());
							List<MyProducts>myProducts=new ArrayList<MyProducts>();
							while(rs.next())
							{
								MyProducts myProduct=new MyProducts();
								myProduct.setName(rs.getString("name"));
								myProduct.setPrice(rs.getDouble("book.price"));
								myProduct.setQuantity(rs.getInt("order_detail.quantity"));
								myProduct.setDiscount(rs.getDouble("book.discount"));
								myProduct.setBook_id(rs.getString("order_detail.bookId"));
								myProducts.add(myProduct);
							}
							orders.setBooks(myProducts);
							
						
						myOrders.add(orders);
						logger.info("data : {}",myProducts.get(0).getBook_id());						
					} 
					
					
					return myOrders;
				} catch (Exception e) {
					logger.error("Error Occured While Establishing The Connection : " + e);
				}
				return null;
			
			}
	}


