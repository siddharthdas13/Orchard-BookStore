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
	String about;
	
	@Inject
	String aboutLink;
	
	@Inject
	String contact;
	
	@Inject
	String contactLink;
	
	@Inject
	String faq;
	
	@Inject
	String faqLink;
	
	@Inject
	String terms;
	
	@Inject
	String termsLink;
	
	@Inject
	String contacts;
	
	@Inject
	String mail;
	
	@Inject
	String phone;

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

	public String getAbout() {
		return about;
	}

	public String getAboutLink() {
		return aboutLink;
	}

	public String getContact() {
		return contact;
	}

	public String getContactLink() {
		return contactLink;
	}

	public String getFaq() {
		return faq;
	}

	public String getFaqLink() {
		return faqLink;
	}

	public String getTerms() {
		return terms;
	}

	public String getTermsLink() {
		return termsLink;
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

	public String getMail() {
		return mail;
	}

	public String getPhone() {
		return phone;
	}
	
	
}
