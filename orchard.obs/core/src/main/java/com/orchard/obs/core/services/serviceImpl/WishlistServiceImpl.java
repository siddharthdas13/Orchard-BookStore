/**
 * 
 */
package com.orchard.obs.core.services.serviceImpl;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.orchard.obs.Exceptions.daoexceptions.WishlistDaoException;
import com.orchard.obs.Exceptions.serviceExceptions.WishlistServiceException;
import com.orchard.obs.core.dao.WishlistDao;
import com.orchard.obs.core.entity.Cart;
import com.orchard.obs.core.services.WishlistService;

/**
 * @author Rushabh
 *
 */
@Component(immediate =  true, service = WishlistService.class)
public class WishlistServiceImpl implements WishlistService {

	@Reference
	WishlistDao wishlistDao;
	
	@Override
	public List<Cart> getWishlistDetails(String dataSourceName, String customerId) throws WishlistServiceException {
		try {
			return wishlistDao.getWishlistDetails(dataSourceName, customerId);
		} catch (WishlistDaoException e) {
			throw new WishlistServiceException(e);
		}
	}

	@Override
	public int addBookToCart(String dataSourceName, String bookId, String customerId) throws WishlistServiceException {
		try {
			return wishlistDao.addBookToCart(dataSourceName, bookId, customerId);
		} catch (WishlistDaoException e) {
			throw new WishlistServiceException(e);
		}
	}

	@Override
	public int deleteWishlistItem(String dataSourceName, String bookId, String customerId)
			throws WishlistServiceException {
		try {
			return wishlistDao.deleteWishlistItem(dataSourceName, bookId, customerId);
		} catch (WishlistDaoException e) {
			throw new WishlistServiceException(e);
		}
	}

}
