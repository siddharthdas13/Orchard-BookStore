package com.orchard.obs.core.services.serviceImpl;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.commons.datasource.poolservice.DataSourcePool;
import com.orchard.obs.Exceptions.daoexceptions.CustomerDaoExceptions;
import com.orchard.obs.Exceptions.serviceExceptions.CustomerServiceExceptions;
import com.orchard.obs.core.dao.RegistrationDao;
import com.orchard.obs.core.models.Customer;
import com.orchard.obs.core.services.RegistrationServices;
import com.orchard.obs.core.util.DBUtil;

@Component(immediate = true, service = RegistrationServices.class)
public class RegistrationServicesImpl implements RegistrationServices {
	private Logger logger = LoggerFactory.getLogger(RegistrationServices.class);
	

	@Reference
	RegistrationDao dao;

	@Override
	public boolean registerUser(String dataSourceName,Customer customer)throws CustomerServiceExceptions {
		boolean status=false;
		try {
			status=dao.registerUser(dataSourceName, customer);
		} catch (CustomerDaoExceptions e) {
			throw new CustomerServiceExceptions(e.getMessage());
		}
		return status;
	}

}
