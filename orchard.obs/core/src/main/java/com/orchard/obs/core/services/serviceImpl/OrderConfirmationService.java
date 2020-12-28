package com.orchard.obs.core.services.serviceImpl;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.orchard.obs.core.dao.daoImpl.OrderConfirmationDao;
import com.orchard.obs.core.entity.Customer;

@Component(immediate =  true, service = OrderConfirmationService.class)
public class OrderConfirmationService {
	@Reference
	OrderConfirmationDao dao;
	public Customer getCustomer(String datasourceName,String cid)
	{
		//PlaceOrderDao dao=new PlaceOrderDao();
		return dao.getCustomer(datasourceName, cid);
	}

}
