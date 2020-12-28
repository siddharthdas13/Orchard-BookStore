/**
 * 
 */
package com.orchard.obs.core.services;

import java.util.List;

import com.orchard.obs.Exceptions.serviceExceptions.CartServiceException;
import com.orchard.obs.core.entity.Book;


/**
 * @author Rushabh
 *
 */
public interface CartService {
	
	public List<Book> getCartDetails(String dataSourceName, int customerId) throws CartServiceException;
	
	public int updateCartDetails(String dataSourceName, String bookId, int cartQuantity, int customerId) throws CartServiceException;

	public int deleteCartItem(String dataSourceName, String bookId, int customerId) throws CartServiceException;
	
}
