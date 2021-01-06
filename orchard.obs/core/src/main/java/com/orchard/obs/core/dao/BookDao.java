/**
 * 
 */
package com.orchard.obs.core.dao;

import com.orchard.obs.Exceptions.daoexceptions.BookDaoException;
import com.orchard.obs.core.entity.Book;

/**
 * @author Rushabh
 *
 */
public interface BookDao {
	
	public Book getBookDetails(String dataSourceName, String bookId, String customerId) throws BookDaoException;

	public int addBookToCart(String dataSourceName, String bookId, String customerId) throws BookDaoException;
}
