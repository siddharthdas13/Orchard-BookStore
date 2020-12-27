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
	public List<Book> getCartDetails(String dataSourceName, int customerId) throws CartDaoException;

	public int updateCartDetails(String dataSourceName, String bookId, int cartQuantity, int customerId) throws CartDaoException;
	
	public int deleteCartItem(String dataSourceName, String bookId, int customerId) throws CartDaoException;
}
