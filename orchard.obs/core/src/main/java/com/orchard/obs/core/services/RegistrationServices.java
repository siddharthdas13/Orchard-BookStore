package com.orchard.obs.core.services;

import com.orchard.obs.Exceptions.serviceExceptions.CustomerServiceExceptions;
import com.orchard.obs.core.models.Customer;

public interface RegistrationServices {
	
	public boolean registerUser(String dataSourceName,Customer customer)throws CustomerServiceExceptions;
}
