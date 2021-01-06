package com.orchard.obs.core.services.serviceImpl;


import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.orchard.obs.core.dao.daoImpl.MyOrderDetailDao;
import com.orchard.obs.core.entity.MyOrderDetail;




@Component(immediate =  true, service = MyOrderDetailService.class)
public class MyOrderDetailService{
	@Reference
	MyOrderDetailDao dao;
	private static final Logger LOG = LoggerFactory.getLogger(MyOrderDetailService.class);
	public MyOrderDetail myOrderDetail(String datasourceName,String oid)
	{
		LOG.info("service ");
		return dao.getMyOrderDetail(datasourceName, oid);
	}
}




