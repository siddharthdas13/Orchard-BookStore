package com.orchard.obs.core.services;

import java.util.List;

import com.orchard.obs.core.models.Book;;

public interface SideNavigationServices {

	public List<String> getBookGenres(String dataSourceName);

	public List<String> getBookPublishers(String dataSourceName);

	public List<Book> getBookBasedOnGenre(String dataSourceName, String genre);

	public List<Book> getBookBasedOnPublisher(String dataSourceName, String publisher);

}
