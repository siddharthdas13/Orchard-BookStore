package com.orchard.obs.core.services.serviceImpl;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.orchard.obs.core.dao.daoImpl.DisplayCartDao;
import com.orchard.obs.core.entity.MyProducts;



@Component(immediate =  true, service = DisplayCartService.class)
public class DisplayCartService {
	@Reference
	DisplayCartDao dao;
	private static final Logger LOG = LoggerFactory.getLogger(DisplayCartService.class);
	public List<MyProducts> getProducts(String datasourceName,String cid)
	{
		LOG.info("service ");
		return dao.getProducts(datasourceName, cid);
	}
}
