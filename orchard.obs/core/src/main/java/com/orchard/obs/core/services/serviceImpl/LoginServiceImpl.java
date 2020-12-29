/**
 * 
 */
package com.orchard.obs.core.services.serviceImpl;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.orchard.obs.Exceptions.daoexceptions.LoginDaoException;
import com.orchard.obs.Exceptions.serviceExceptions.LoginServiceException;
import com.orchard.obs.core.dao.LoginDao;
import com.orchard.obs.core.models.Customer;
import com.orchard.obs.core.services.LoginService;

/**
 * @author Rushabh
 *
 */
@Component(service = LoginService.class, immediate = true)
public class LoginServiceImpl implements LoginService {

	@Reference
	LoginDao loginDao;
	
	@Override
	public Customer getCustomerDetails(String dataSourceName, String name, String password)
			throws LoginServiceException {
		try {
			return loginDao.getCustomerDetails(dataSourceName, name, password);
		} catch (LoginDaoException e) {
			throw new LoginServiceException(e);
		}
	}
}
