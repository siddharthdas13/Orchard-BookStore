/**
 * 
 */
package com.orchard.obs.core.services;

import com.orchard.obs.Exceptions.serviceExceptions.LoginServiceException;
import com.orchard.obs.core.models.Customer;

/**
 * @author Rushabh
 *
 */
public interface LoginService {

	public Customer getCustomerDetails(String dataSourceName, String name, String password) throws LoginServiceException;

}
