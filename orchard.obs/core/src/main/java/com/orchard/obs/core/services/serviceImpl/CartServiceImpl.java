/**
 * 
 */
package com.orchard.obs.core.services.serviceImpl;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.orchard.obs.Exceptions.daoexceptions.CartDaoException;
import com.orchard.obs.Exceptions.serviceExceptions.CartServiceException;
import com.orchard.obs.core.dao.CartDao;
import com.orchard.obs.core.entity.Book;
import com.orchard.obs.core.services.CartService;

/**
 * @author Rushabh
 *
 */
@Component(immediate =  true, service = CartService.class)
public class CartServiceImpl implements CartService {

	@Reference
	CartDao cartDao;
	
	@Override
	public List<Book> getCartDetails(String dataSourceName, String customerId) throws CartServiceException {
		try {
			return cartDao.getCartDetails(dataSourceName, customerId);
		} catch (CartDaoException e) {
			throw new CartServiceException(e);
		}
	}

	@Override
	public int updateCartDetails(String dataSourceName, String bookId, int cartQuantity, String customerId)
			throws CartServiceException {
		try {
			return cartDao.updateCartDetails(dataSourceName, bookId, cartQuantity, customerId);
		} catch (CartDaoException e) {
			throw new CartServiceException(e);
		}
	}

	@Override
	public int deleteCartItem(String dataSourceName, String bookId, String customerId) throws CartServiceException {
		try {
			return cartDao.deleteCartItem(dataSourceName, bookId, customerId);
		} catch (CartDaoException e) {
			throw new CartServiceException(e);
		}
	}

}
