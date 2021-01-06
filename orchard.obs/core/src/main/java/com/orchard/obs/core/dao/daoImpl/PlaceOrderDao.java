package com.orchard.obs.core.dao.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.commons.datasource.poolservice.DataSourcePool;


@Component(immediate =  true, service = PlaceOrderDao.class)
public class PlaceOrderDao {
	
	
	private Logger logger = LoggerFactory.getLogger(PlaceOrderDao.class);
			
			@Reference
			DataSourcePool source;
			
			public int placeOrder(String dataSourceName,String customerId)
			{
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
				   LocalDateTime now = LocalDateTime.now();
				   
				   DateTimeFormatter dtff = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				   LocalDateTime noww = LocalDateTime.now();
				   
				DataSource dataSource = null;
				Connection connection = null;
				PreparedStatement statement = null;
				ResultSet rs=null;
				Statement stmt=null;
				String sql="insert into orders values(?,?,?,?)";
				String orderno="";
				try {
					logger.info("Inside Connection, Source Is {}", source);
					dataSource = (DataSource) source.getDataSource(dataSourceName);
					connection = dataSource.getConnection();
					logger.info("Working : {}", connection);
					statement = connection.prepareStatement(sql);
					statement.setString(1, null);
					statement.setString(2, customerId);
					statement.setString(3,dtff.format(noww));
					statement.setString(4,dtf.format(now) );
					statement.execute();
					stmt=connection.createStatement();
					sql="select max(order_id) from orders where customer_id="+"'"+customerId+"'";
					rs=stmt.executeQuery(sql);
					while(rs.next())
					{
						 orderno=rs.getString(1);
					}
					logger.info("order : {}", orderno);
					logger.info("orderParse : {}",Integer.parseInt(orderno));
					sql="insert into order_detail (order_id,bookId,quantity) select order_id,bookId,quantity from cart inner join orders on orders.customer_id=cart.customer_id where order_id="+Integer.parseInt(orderno);
					statement.executeUpdate(sql);
					sql="delete from cart where customer_id='"+customerId+"'";
					statement.executeUpdate(sql);
				} catch (Exception e) {
					logger.error("Error Occured While Establishing The Connection : " + e.getCause());
				}
				return Integer.parseInt(orderno);
				
			
			}
	}

