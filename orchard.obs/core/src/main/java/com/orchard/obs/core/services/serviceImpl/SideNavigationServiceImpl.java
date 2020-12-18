package com.orchard.obs.core.services.serviceImpl;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.orchard.obs.core.dao.SideNavigationDao;
import com.orchard.obs.core.models.Book;
import com.orchard.obs.core.services.SideNavigationServices;

@Component(immediate = true, service = SideNavigationServices.class)
public class SideNavigationServiceImpl implements SideNavigationServices {

	@Reference
	SideNavigationDao sideNavigationDao;

	@Override
	public List<String> getBookGenres(String dataSourceName) {
		return sideNavigationDao.getBookGenres(dataSourceName);
	}

	@Override
	public List<String> getBookPublishers(String dataSourceName) {
		return sideNavigationDao.getBookPublishers(dataSourceName);
	}

	@Override
	public List<Book> getBookBasedOnGenre(String dataSourceName, String genre) {
		return sideNavigationDao.getBookBasedOnGenre(dataSourceName, genre);
	}

	@Override
	public List<Book> getBookBasedOnPublisher(String dataSourceName, String publisher) {
		return sideNavigationDao.getBookBasedOnPublisher(dataSourceName, publisher);
	}

}
