package com.orchard.obs.core.dao;

import java.util.List;

import com.orchard.obs.Exceptions.daoexceptions.CustomerDaoExceptions;
import com.orchard.obs.core.models.Customer;

public interface RegistrationDao {
	public boolean registerUser(String dataSourceName,Customer customer)throws CustomerDaoExceptions;

	public List<String> checkDuplicateMail(String dataSourceName, String mail)throws CustomerDaoExceptions;
}
