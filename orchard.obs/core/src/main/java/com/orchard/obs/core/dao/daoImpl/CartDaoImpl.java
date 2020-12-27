/**
 * 
 */
package com.orchard.obs.core.dao.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.day.commons.datasource.poolservice.DataSourceNotFoundException;
import com.orchard.obs.Exceptions.daoexceptions.CartDaoException;
import com.orchard.obs.core.dao.CartDao;
import com.orchard.obs.core.entity.Book;
import com.orchard.obs.core.util.DBUtil;

/**
 * @author Rushabh
 *
 */
@Component(immediate =  true, service = CartDao.class)
public class CartDaoImpl implements CartDao {

	@Reference
	DBUtil dbUtil;

	@Override
	public List<Book> getCartDetails(String dataSourceName, int customerId) throws CartDaoException {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		List<Book> bookList = new ArrayList<Book>();

		try {
			connection = dbUtil.getConnection(dataSourceName);
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT B.ISBN, B.NAME, P.PUBLISHERNAME, B.PAGECOUNT, B.EDITION, B.LANGUAGE, B.QUANTITY, B.PRICE, B.DISCOUNT, G.GENRENAME, C.QUANTITY FROM CART C JOIN BOOK B ON C.ISBN = B.ISBN INNER JOIN PUBLISHER P ON P.PUBLISHERID = B.PUBLISHERID INNER JOIN GENRE G ON G.GENREID = B.GENREID AND C.CUSTOMER_ID = " + customerId + ";");

			while (resultSet.next()) {
				Book book = new Book();
				//Populate Employee object with data from MySQL
				book.setId(resultSet.getString(1));
				book.setName(resultSet.getString(2)); 
				book.setPublisher(resultSet.getString(3));
				book.setPageCount(resultSet.getInt(4));
				book.setEdition(resultSet.getString(5));
				book.setLanguage(resultSet.getString(6));
				book.setQuantity(resultSet.getInt(7));
				book.setPrice(resultSet.getInt(8));
				book.setDiscount(resultSet.getInt(9));
				book.setCategory(resultSet.getString(10));
				book.setCartQuantity(resultSet.getInt(11));

				//Push the Employee Object to the list
				bookList.add(book);
			} 	
		} catch (DataSourceNotFoundException | SQLException e) {
			throw new CartDaoException(e);
		}

		finally {
			dbUtil.closeResource(resultSet);
			dbUtil.closeResource(statement);
			dbUtil.closeResource(connection);
		}
		return bookList;
	}

	@Override
	public int updateCartDetails(String dataSourceName, String bookId, int cartQuantity, int customerId)
			throws CartDaoException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int status = 0;
		try {
			connection = dbUtil.getConnection(dataSourceName);
			preparedStatement = connection.prepareStatement("UPDATE CART SET QUANTITY = ? WHERE ISBN = ? AND CUSTOMER_ID = " + customerId + ";");
			preparedStatement.setInt(1, cartQuantity);
			preparedStatement.setString(2, bookId);
			status = preparedStatement.executeUpdate();
		} catch (DataSourceNotFoundException | SQLException e) {
			throw new CartDaoException(e);
		}
		finally {
			dbUtil.closeResource(preparedStatement);
			dbUtil.closeResource(connection);
		}
		return status;
	}

	@Override
	public int deleteCartItem(String dataSourceName, String bookId, int customerId) throws CartDaoException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int status = 0;

		try {
			connection = dbUtil.getConnection(dataSourceName);
			preparedStatement = connection.prepareStatement("DELETE FROM CART WHERE BOOK_ID = ? AND CUSTOMER_ID = " + customerId + ";");
			preparedStatement.setString(1, bookId);
			status = preparedStatement.executeUpdate();
		} catch (DataSourceNotFoundException | SQLException e) {
			throw new CartDaoException(e);
		}
		finally {
			dbUtil.closeResource(preparedStatement);
			dbUtil.closeResource(connection);
		}
		return status;
	}

}
