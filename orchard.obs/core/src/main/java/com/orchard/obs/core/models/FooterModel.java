package com.orchard.obs.core.models;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

@Model(adaptables = Resource.class , defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class FooterModel {
	
	@Inject
	String aboutUs;
	
	@Inject
	String aboutUsContent;
	
	@Inject
	String shop;
	
	@Inject
	String shopContent;
	
	@Inject
	String newsletter;
	
	@Inject
	String info;
	
	@Inject
	String contacts;
	
	@Inject
	String contactContent;

	public String getAboutUs() {
		return aboutUs;
	}

	public String getShop() {
		return shop;
	}

	public String getNewsletter() {
		return newsletter;
	}

	public String getInfo() {
		return info;
	}

	public String getContacts() {
		return contacts;
	}

	public String getAboutUsContent() {
		return aboutUsContent;
	}

	public String getShopContent() {
		return shopContent;
	}

	public String getContactContent() {
		return contactContent;
	}
}
