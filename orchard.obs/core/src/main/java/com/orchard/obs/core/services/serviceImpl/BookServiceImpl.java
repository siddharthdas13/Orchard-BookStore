/**
 * 
 */
package com.orchard.obs.core.services.serviceImpl;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.orchard.obs.Exceptions.daoexceptions.BookDaoException;
import com.orchard.obs.Exceptions.serviceExceptions.BookServiceException;
import com.orchard.obs.core.dao.BookDao;
import com.orchard.obs.core.entity.Book;
import com.orchard.obs.core.services.BookService;

/**
 * @author Rushabh
 *
 */
@Component(immediate = true, service = BookService.class)
public class BookServiceImpl implements BookService {

	@Reference
	BookDao bookDao;
	
	@Override
	public Book getBookDetails(String dataSourceName, String bookId) throws BookServiceException {
		try {
			return bookDao.getBookDetails(dataSourceName, bookId);
		} catch (BookDaoException e) {
			throw new BookServiceException(e.getCause());
		}
	}

	@Override
	public int addBookToCart(String dataSourceName, String bookId, String customerId) throws BookServiceException {
		try {
			return bookDao.addBookToCart(dataSourceName, bookId, customerId);
		} catch (BookDaoException e) {
			throw new BookServiceException(e.getCause());
		}
	}

}
