package com.orchard.obs.core.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.commons.datasource.poolservice.DataSourcePool;
;
@Component(immediate =  true, service = SideNavigationServices.class)
public class SideNavigationServices {
	
	
	private Logger logger = LoggerFactory.getLogger(SideNavigationServices.class);
	@Reference
	DataSourcePool source;
	
	
	public Connection getConnection(String dataSourceName) {
		DataSource dataSource = null;
		Connection connection = null;
		try {
			logger.error("Inside Connection , Source Is {}", source);
			dataSource = (DataSource) source.getDataSource(dataSourceName);
			connection = dataSource.getConnection();
		} catch (Exception e) {
			logger.error("Error Occured While Establishing The Connection : " + e);
		}
		return connection;
	}

	public List<String> getBookGenres(String dataSourceName) {
		Connection connection = getConnection(dataSourceName);
		Statement statement = null;
		ResultSet resultSet = null;
		List<String> genres = new ArrayList<>();
		try {
			logger.error("Inside Connection, Source Is {}", source);
			String query = "SELECT GENRENAME FROM GENRE";
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				genres.add(resultSet.getString("GENRENAME"));
			}
		} catch (Exception e) {
			logger.error("Error Occured  While Establishing The  Connection : " + e);
		} finally {
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return genres;
	}

	public List<String> getBookPublishers(String dataSourceName) {
		Connection connection = getConnection(dataSourceName);
		Statement statement = null;
		ResultSet resultSet = null;
		List<String> publishers = new ArrayList<>();
		try {
			logger.error("Inside Connection, Source Is {}", source);
			String query = "SELECT PUBLISHERNAME FROM PUBLISHER";
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				publishers.add(resultSet.getString("PUBLISHERNAME"));
			}
		} catch (Exception e) {
			logger.error("Error Occured  While Establishing The  Connection : " + e);
		} finally {
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return publishers;
	}

	/*@Override
	public List<Book> getBookBasedOnGenre(String dataSourceName, String genre) {
		Connection connection = getConnection(dataSourceName);
		Statement statement = null;
		ResultSet resultSet = null;
		List<Book> books = new ArrayList<>();
		try {
			logger.error("Inside Connection, Source Is  {}", source);
			statement = connection.createStatement();
			String query = "SELECT * FROM BOOK INNER JOIN GENRE ON BOOK.GENREID=GENRE.GENREID WHERE GENRE.GENRENAME='"
					+ genre + "'";
			resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				Book book = new Book();
				book.setISBN(resultSet.getString("ISBN"));
				book.setName(resultSet.getString("NAME"));
				book.setPageCount(resultSet.getInt("PAGECOUNT"));
				book.setEdition(resultSet.getString("EDITION"));
				book.setPublishedDate(resultSet.getDate("PUBLISHDATE"));
				book.setPrice(resultSet.getFloat("PRICE"));
				book.setDiscount(resultSet.getFloat("DISCOUNT"));
				book.setRating(resultSet.getFloat("RATING"));
				book.setDescription(resultSet.getString("NAME"));

				books.add(book);
			}
		} catch (Exception e) {
			logger.error("Error Occured  While Establishing The Connection : " + e);
		} finally {
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return books;
	}

	@Override
	public List<Book> getBookBasedOnPublisher(String dataSourceName, String publisher) {
		Connection connection = getConnection(dataSourceName);
		Statement statement = null;
		ResultSet resultSet = null;
		List<Book> books = new ArrayList<>();
		try {
			logger.error("Inside Connection, Source Is  {}", source);
			statement = connection.createStatement();
			String query = "SELECT * FROM BOOK INNER JOIN PUBLISHER ON BOOK.PUBLISHERID=PUBLISHER.PUBLISHERID WHERE PUBLISHER.PUBLISHERNAME='"
					+ publisher + "'";
			resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				Book book = new Book();
				book.setISBN(resultSet.getString("ISBN"));
				book.setName(resultSet.getString("NAME"));
				book.setPageCount(resultSet.getInt("PAGECOUNT"));
				book.setEdition(resultSet.getString("EDITION"));
				book.setPublishedDate(resultSet.getDate("PUBLISHDATE"));
				book.setPrice(resultSet.getFloat("PRICE"));
				book.setDiscount(resultSet.getFloat("DISCOUNT"));
				book.setRating(resultSet.getFloat("RATING"));
				book.setDescription(resultSet.getString("NAME"));

				books.add(book);
			}
		} catch (Exception e) {
			logger.error("Error Occured  While Establishing The Connection : " + e);
		} finally {
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return books;
	}*/

}
