package com.orchard.obs.core.services.serviceImpl;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.orchard.obs.Exceptions.daoexceptions.SideNavigationDaoException;
import com.orchard.obs.Exceptions.serviceExceptions.SideNavigationServiceException;
import com.orchard.obs.core.dao.SideNavigationDao;
import com.orchard.obs.core.models.Book;
import com.orchard.obs.core.services.SideNavigationServices;

@Component(immediate = true, service = SideNavigationServices.class)
public class SideNavigationServiceImpl implements SideNavigationServices {

	@Reference
	SideNavigationDao sideNavigationDao;

	@Override
	public List<String> getBookGenres(String dataSourceName) throws SideNavigationServiceException {
		try {
			return sideNavigationDao.getBookGenres(dataSourceName);
		} catch (SideNavigationDaoException e) {
			throw new SideNavigationServiceException(e);
		}
	}

	@Override
	public List<String> getBookPublishers(String dataSourceName) throws SideNavigationServiceException {
		try {
			return sideNavigationDao.getBookPublishers(dataSourceName);
		} catch (SideNavigationDaoException e) {
			throw new SideNavigationServiceException(e);
		}
	}

	@Override
	public List<Book> getBookBasedOnGenre(String dataSourceName, String genre) throws SideNavigationServiceException {
		try {
			return sideNavigationDao.getBookBasedOnGenre(dataSourceName, genre);
		} catch (SideNavigationDaoException e) {
			throw new SideNavigationServiceException(e);
		}
	}

	@Override
	public List<Book> getBookBasedOnPublisher(String dataSourceName, String publisher) throws SideNavigationServiceException {
		try {
			return sideNavigationDao.getBookBasedOnPublisher(dataSourceName, publisher);
		} catch (SideNavigationDaoException e) {
			throw new SideNavigationServiceException(e);
		}
	}

	@Override
	public List<Book> getBookBasedOnGenreAndPublisher(String dataSourceName, String genre, String publisher) throws SideNavigationServiceException {
		try {
			return sideNavigationDao.getBookBasedOnGenreAndPublisher(dataSourceName, genre, publisher);
		} catch (SideNavigationDaoException e) {
			throw new SideNavigationServiceException(e);
		}
	}

}
