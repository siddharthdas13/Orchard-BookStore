/**
 * 
 */
package com.orchard.obs.core.services;

import com.orchard.obs.Exceptions.serviceExceptions.BookServiceException;
import com.orchard.obs.core.entity.Book;

/**
 * @author Rushabh
 *
 */
public interface BookService {

	public Book getBookDetails(String dataSourceName, String bookId, String customerId) throws BookServiceException;

	public int addBookToCart(String dataSourceName, String bookId, String customerId) throws BookServiceException;

}
