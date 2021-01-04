package com.orchard.obs.core.models;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.orchard.obs.Exceptions.serviceExceptions.SideNavigationServiceException;
import com.orchard.obs.core.services.SideNavigationServices;
import com.orchard.obs.core.servlets.FilterBookServlet;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class SideNavigationModel {
	private Logger logger = LoggerFactory.getLogger(FilterBookServlet.class);
	List<String> bookGenres;
	List<String> bookPublishers;

	@OSGiService
	SideNavigationServices sideNavigationServices;

	@PostConstruct
	protected void init() {
		try {
			bookGenres = sideNavigationServices.getBookGenres("bookworm");
			bookPublishers = sideNavigationServices.getBookPublishers("bookworm");
		} catch (SideNavigationServiceException e) {
			logger.info(e.getMessage());
		}
		
	}

	public List<String> getBookGenres() {
		return bookGenres;
	}

	public List<String> getBookPublishers() {
		return bookPublishers;
	}

}
