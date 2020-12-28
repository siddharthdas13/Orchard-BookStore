/**
 * 
 */
package com.orchard.obs.core.dao;

import java.util.List;

import com.orchard.obs.Exceptions.daoexceptions.CartDaoException;
import com.orchard.obs.core.entity.Book;
/**
 * @author Rushabh
 *
 */
public interface CartDao {
	public List<Book> getCartDetails(String dataSourceName, String customerId) throws CartDaoException;

	public int updateCartDetails(String dataSourceName, String bookId, int cartQuantity, String customerId) throws CartDaoException;
	
	public int deleteCartItem(String dataSourceName, String bookId, String customerId) throws CartDaoException;
}
