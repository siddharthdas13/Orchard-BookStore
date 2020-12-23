package com.orchard.obs.core.dao;

import com.orchard.obs.Exceptions.daoexceptions.CustomerDaoExceptions;
import com.orchard.obs.core.models.Customer;

public interface RegistrationDao {
	public boolean registerUser(String dataSourceName,Customer customer)throws CustomerDaoExceptions;
}
