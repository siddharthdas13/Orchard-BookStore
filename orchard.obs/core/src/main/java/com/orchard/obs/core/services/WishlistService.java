/**
 * 
 */
package com.orchard.obs.core.services;

import java.util.List;

import com.orchard.obs.Exceptions.serviceExceptions.WishlistServiceException;
import com.orchard.obs.core.entity.Cart;

/**
 * @author Rushabh
 *
 */
public interface WishlistService {

	public List<Cart> getWishlistDetails(String dataSourceName, String customerId) throws WishlistServiceException;

	public int addBookToCart(String dataSourceName, String bookId, String customerId) throws WishlistServiceException;
	
	public int deleteWishlistItem(String dataSourceName, String bookId, String customerId) throws WishlistServiceException;

}
