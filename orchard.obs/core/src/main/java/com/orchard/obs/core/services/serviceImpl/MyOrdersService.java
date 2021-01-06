package com.orchard.obs.core.services.serviceImpl;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.orchard.obs.core.dao.daoImpl.MyOrdersDao;
import com.orchard.obs.core.entity.MyOrders;



@Component(immediate =  true, service = MyOrdersService.class)
public class MyOrdersService {
	@Reference
	MyOrdersDao dao;
	private static final Logger LOG = LoggerFactory.getLogger(MyOrdersService.class);
	public List<MyOrders> myOrders(String datasourceName,String cid)
	{
		LOG.info("service ");
		return dao.getMyOrders(datasourceName, cid);
	}
}


