/**
 * 
 */
package com.orchard.obs.core.dao;

import java.util.List;

import com.orchard.obs.Exceptions.daoexceptions.WishlistDaoException;
import com.orchard.obs.core.entity.Cart;

/**
 * @author Rushabh
 *
 */
public interface WishlistDao {
	
	public List<Cart> getWishlistDetails(String dataSourceName, String customerId) throws WishlistDaoException;

	public int addBookToCart(String dataSourceName, String bookId, String customerId) throws WishlistDaoException;
	
	public int deleteWishlistItem(String dataSourceName, String bookId, String customerId) throws WishlistDaoException;

}
