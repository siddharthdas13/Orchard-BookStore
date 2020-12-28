package com.orchard.obs.core.services.serviceImpl;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.orchard.obs.core.dao.daoImpl.PlaceOrderDao;


@Component(immediate =  true, service = PlaceOrderService.class)
public class PlaceOrderService {
	@Reference
	PlaceOrderDao dao;
	private static final Logger LOG = LoggerFactory.getLogger(PlaceOrderService.class);
	public int placeOrder(String datasourceName,String cid)
	{
		LOG.info("service ");
		return dao.placeOrder(datasourceName, cid);
	}
}
