package com.orchard.obs.core.dao.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.commons.datasource.poolservice.DataSourcePool;
import com.orchard.obs.core.dao.SideNavigationDao;
import com.orchard.obs.core.models.Book;
import com.orchard.obs.core.services.SideNavigationServices;
import com.orchard.obs.core.util.DBConnectionUtil;

@Component(immediate = true, service = SideNavigationDao.class)
public class SideNavigationDaoImpl implements SideNavigationDao {

	private Logger logger = LoggerFactory.getLogger(SideNavigationServices.class);
	@Reference
	DBConnectionUtil dbConnectionUtil;

	@Reference
	DataSourcePool source;

	@Override
	public List<String> getBookGenres(String dataSourceName) {
		Connection connection = dbConnectionUtil.getConnection(dataSourceName);
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
			dbConnectionUtil.closeResource(resultSet);
			dbConnectionUtil.closeResource(statement);
			dbConnectionUtil.closeResource(connection);
		}
		return genres;
	}

	@Override
	public List<String> getBookPublishers(String dataSourceName) {
		Connection connection = dbConnectionUtil.getConnection(dataSourceName);
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
			dbConnectionUtil.closeResource(resultSet);
			dbConnectionUtil.closeResource(statement);
			dbConnectionUtil.closeResource(connection);
		}
		return publishers;
	}

	@Override
	public List<Book> getBookBasedOnGenre(String dataSourceName, String genre) {
		Connection connection = dbConnectionUtil.getConnection(dataSourceName);
		Statement statement = null;
		Statement statement1 = null;
		ResultSet resultSet = null;
		ResultSet resultSet1 = null;
		List<Book> books = new ArrayList<>();
		try {
			logger.info("Inside getBookBasedOnGenre method");
			statement = connection.createStatement();
			String query = "SELECT * FROM BOOK";
			if (!(genre.equals("all")))
				query = "SELECT * FROM BOOK INNER JOIN GENRE ON BOOK.GENREID=GENRE.GENREID WHERE GENRE.GENRENAME LIKE'"
						+ genre + "'";
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				Book book = new Book();
				book.setName(resultSet.getString("NAME"));
				book.setLanguage(resultSet.getString("LANGUAGE"));
				book.setPrice(resultSet.getFloat("PRICE"));
				book.setNew(resultSet.getBoolean("NEWITEM"));
				book.setDiscount(resultSet.getFloat("DISCOUNT"));
				book.setBestSeller(resultSet.getBoolean("BESTSELLER"));
				statement1 = connection.createStatement();
				query = "SELECT DISTINCT AUTHOR.AUTHORNAME FROM AUTHOR INNER JOIN AUTHOR_BOOK ON AUTHOR.AUTHORID=AUTHOR_BOOK.AUTHORID WHERE AUTHOR_BOOK.BOOKID='"
						+ resultSet.getString("ISBN") + "'";

				resultSet1 = statement1.executeQuery(query);
				List<String> authors = new ArrayList<>();
				while (resultSet1.next()) {
					authors.add(resultSet1.getString("AUTHORNAME"));
				}
				book.setAuthors(authors);
				books.add(book);
			}
		} catch (Exception e) {
			logger.error("Error Occured  While Establishing The Connection : " + e);
		} finally {
			dbConnectionUtil.closeResource(resultSet1);
			dbConnectionUtil.closeResource(resultSet);
			dbConnectionUtil.closeResource(statement1);
			dbConnectionUtil.closeResource(statement);
			dbConnectionUtil.closeResource(connection);
		}
		return books;
	}

	@Override
	public List<Book> getBookBasedOnPublisher(String dataSourceName, String publisher) {
		Connection connection = dbConnectionUtil.getConnection(dataSourceName);
		Statement statement = null;
		Statement statement1 = null;
		ResultSet resultSet = null;
		ResultSet resultSet1 = null;
		List<Book> books = new ArrayList<>();
		try {
			logger.info("Inside getBookBasedOnPublisher method");
			statement = connection.createStatement();
			String query = "SELECT * FROM BOOK";
			if (!(publisher.equals("all")))
			query = "Select * FROM BOOK INNER JOIN PUBLISHER ON BOOK.PUBLISHERID=PUBLISHER.PUBLISHERID WHERE PUBLISHER.PUBLISHERNAME LIKE'"
					+ publisher + "'";
			resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				Book book = new Book();

				book.setName(resultSet.getString("NAME"));
				book.setLanguage(resultSet.getString("LANGUAGE"));
				book.setPrice(resultSet.getFloat("PRICE"));
				book.setNew(resultSet.getBoolean("NEWITEM"));
				book.setDiscount(resultSet.getFloat("DISCOUNT"));
				book.setBestSeller(resultSet.getBoolean("BESTSELLER"));
				statement1 = connection.createStatement();
				query = "SELECT DISTINCT AUTHOR.AUTHORNAME FROM AUTHOR INNER JOIN AUTHOR_BOOK ON AUTHOR.AUTHORID=AUTHOR_BOOK.AUTHORID WHERE AUTHOR_BOOK.BOOKID='"
						+ resultSet.getString("ISBN") + "'";

				resultSet1 = statement1.executeQuery(query);
				List<String> authors = new ArrayList<>();
				while (resultSet1.next()) {
					authors.add(resultSet1.getString("AUTHORNAME"));
				}
				book.setAuthors(authors);

				books.add(book);
			}
		} catch (Exception e) {
			logger.error("Error Occured  While Establishing The Connection : " + e);
		} finally {
			dbConnectionUtil.closeResource(resultSet1);
			dbConnectionUtil.closeResource(resultSet);
			dbConnectionUtil.closeResource(statement1);
			dbConnectionUtil.closeResource(statement);
			dbConnectionUtil.closeResource(connection);
		}
		return books;
	}

	@Override
	public List<Book> getBookBasedOnGenreAndPublisher(String dataSourceName, String genre, String publisher) {
		Connection connection = dbConnectionUtil.getConnection(dataSourceName);
		Statement statement = null;
		Statement statement1 = null;
		ResultSet resultSet = null;
		ResultSet resultSet1 = null;
		List<Book> books = new ArrayList<>();
		try {
			logger.info("INISDE getBookBasedOnGenreAndPublisher METHOD");
			statement = connection.createStatement();
			String query = "SELECT BOOK.* FROM BOOK INNER JOIN GENRE on BOOK.GENREID=GENRE.GENREID \n"
					+ "	INNER JOIN PUBLISHER ON BOOK.PUBLISHERID=PUBLISHER.PUBLISHERID WHERE (PUBLISHER.PUBLISHERNAME='"
					+ publisher + "') AND (GENRE.GENRENAME='" + genre + "');";
			resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				Book book = new Book();

				book.setName(resultSet.getString("NAME"));
				book.setLanguage(resultSet.getString("LANGUAGE"));
				book.setPrice(resultSet.getFloat("PRICE"));
				book.setNew(resultSet.getBoolean("NEWITEM"));
				book.setDiscount(resultSet.getFloat("DISCOUNT"));
				book.setBestSeller(resultSet.getBoolean("BESTSELLER"));
				statement1 = connection.createStatement();
				query = "SELECT AUTHOR.AUTHORNAME FROM AUTHOR INNER JOIN AUTHOR_BOOK ON AUTHOR.AUTHORID=AUTHOR_BOOK.AUTHORID WHERE AUTHOR_BOOK.BOOKID='"
						+ resultSet.getString("ISBN") + "'";
				resultSet1 = statement1.executeQuery(query);
				List<String> authors = new ArrayList<>();
				while (resultSet1.next()) {
					authors.add(resultSet1.getString("AUTHORNAME"));
				}
				book.setAuthors(authors);
				
				books.add(book);
			}
		} catch (Exception e) {
			logger.error("Error Occured  While Establishing The Connection : " + e);
		} finally {
			dbConnectionUtil.closeResource(resultSet1);
			dbConnectionUtil.closeResource(resultSet);
			dbConnectionUtil.closeResource(statement1);
			dbConnectionUtil.closeResource(statement);
			dbConnectionUtil.closeResource(connection);
		}
		return books;
	}
}
