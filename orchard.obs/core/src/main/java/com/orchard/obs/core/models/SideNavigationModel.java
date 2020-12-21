package com.orchard.obs.core.models;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;

import com.orchard.obs.core.services.SideNavigationServices;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class SideNavigationModel {

	List<String> bookGenres;
	List<String> bookPublishers;

	@OSGiService
	SideNavigationServices sideNavigationServices;

	@PostConstruct
	protected void init() {
		bookGenres = sideNavigationServices.getBookGenres("table");
		bookPublishers = sideNavigationServices.getBookPublishers("table");
	}

	public List<String> getBookGenres() {
		return bookGenres;
	}

	public List<String> getBookPublishers() {
		return bookPublishers;
	}

}
