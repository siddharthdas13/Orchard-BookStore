/**
 * 
 */
package com.orchard.obs.core.dao;

import com.orchard.obs.Exceptions.daoexceptions.LoginDaoException;
import com.orchard.obs.core.models.Customer;

/**
 * @author Rushabh
 *
 */
public interface LoginDao {

	public Customer getCustomerDetails(String dataSourceName, String name, String password) throws LoginDaoException;

}
