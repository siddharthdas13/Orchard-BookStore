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
import com.orchard.obs.core.entity.Customer;
import com.orchard.obs.core.entity.MyOrderDetail;
import com.orchard.obs.core.entity.MyProducts;


@Component(immediate =  true, service = MyOrderDetailDao.class)
public class MyOrderDetailDao {
	
	
	private Logger logger = LoggerFactory.getLogger(MyOrderDetailDao.class);
			
			@Reference
			DataSourcePool source;
			
			public MyOrderDetail getMyOrderDetail(String dataSourceName,String orderId)
			{
				logger.error("order {}", orderId);
				DataSource dataSource = null;
				Connection connection = null;
				Statement statement = null;
				ResultSet resultSet = null;
				MyOrderDetail myOrderDetail=new MyOrderDetail();
				try {
					logger.error("Inside Connection, Source Is {}", source);
					dataSource = (DataSource) source.getDataSource(dataSourceName);
					connection = dataSource.getConnection();
					logger.info("Working : {}", connection);
					statement = connection.createStatement();
					resultSet = statement.executeQuery("Select * FROM orders where order_id="+orderId);
					while (resultSet.next()) {
						Statement stmt=connection.createStatement();
						myOrderDetail.setCustomer_id(resultSet.getString("customer_id"));
						myOrderDetail.setDate(resultSet.getString("order_date"));
						myOrderDetail.setTime(resultSet.getString("order_time"));
						Customer customer=new Customer();
						ResultSet rs=stmt.executeQuery("Select * from customer where customer_id='"+myOrderDetail.getCustomer_id()+"'");
						List<MyProducts> myProducts=new ArrayList<MyProducts>();
						while(rs.next())
						{
							customer.setName(rs.getString("custName"));
							customer.setPin(rs.getString("pin"));
							customer.setAddress(rs.getString("address"));
							customer.setCountry(rs.getString("country"));
							customer.setCity(rs.getString("city"));
							customer.setPhone(rs.getString("phone"));
							customer.setState(rs.getString("state"));
						}
						myOrderDetail.setCustomer(customer);
						logger.error("customer {}",myOrderDetail.getCustomer().getName());
						rs=stmt.executeQuery("select * from ((order_detail INNER JOIN orders ON order_detail.order_id=orders.order_id ) INNER JOIN book on order_detail.bookId=book.bookId ) where orders.order_id="+orderId);
						logger.error("success");
						while(rs.next())
						{
							MyProducts products=new  MyProducts();
							products.setName(rs.getString("book.name"));
							products.setPrice(rs.getDouble("book.price"));
							products.setDiscount(rs.getDouble("book.discount"));
							products.setQuantity(rs.getInt("order_detail.quantity"));
							products.setEdition(rs.getString("book.edition"));
							
							products.setLanguage(rs.getString("book.language"));
							myProducts.add(products);
						}
						myOrderDetail.setMyProducts(myProducts);
						logger.info("data : {}",myProducts.get(0).getBook_id());						
					} 
					
					
					return myOrderDetail;
				} catch (Exception e) {
					logger.error("Error Occured While Establishing The Connection : " + e.getMessage());
				}
				return null;
			
			}
	}

