package com.orchard.obs.core.services;

import java.util.List;

import com.orchard.obs.Exceptions.serviceExceptions.SideNavigationServiceException;
import com.orchard.obs.core.models.Book;;

public interface SideNavigationServices {

	public List<String> getBookGenres(String dataSourceName) throws SideNavigationServiceException;

	public List<String> getBookPublishers(String dataSourceName) throws SideNavigationServiceException;

	public List<Book> getBookBasedOnGenre(String dataSourceName, String genre) throws SideNavigationServiceException;

	public List<Book> getBookBasedOnPublisher(String dataSourceName, String publisher)
			throws SideNavigationServiceException;

	public List<Book> getBookBasedOnGenreAndPublisher(String dataSourceName, String genre, String publisher)
			throws SideNavigationServiceException;
}
