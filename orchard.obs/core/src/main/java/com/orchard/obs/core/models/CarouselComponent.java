package com.orchard.obs.core.models;
import javax.inject.*;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.*;

@Model(adaptables=Resource.class, defaultInjectionStrategy=DefaultInjectionStrategy.OPTIONAL)

public class CarouselComponent {
	
	@Inject
	String slideOneImage;
	
	@Inject
	String slideOneText;
	
	@Inject
	String slideOneLink;
	
	@Inject
	String slideTwoImage;
	
	@Inject
	String slideTwoText;
	
	@Inject
	String slideTwoLink;

	@Inject
	String slideThreeImage;
	
	@Inject
	String slideThreeText;
	
	@Inject
	String slideThreeLink;

	public String getSlideOneImage() {
		return slideOneImage;
	}

	public String getSlideOneText() {
		return slideOneText;
	}

	public String getSlideOneLink() {
		return slideOneLink;
	}

	public String getSlideTwoImage() {
		return slideTwoImage;
	}

	public String getSlideTwoText() {
		return slideTwoText;
	}

	public String getSlideTwoLink() {
		return slideTwoLink;
	}

	public String getSlideThreeImage() {
		return slideThreeImage;
	}

	public String getSlideThreeText() {
		return slideThreeText;
	}

	public String getSlideThreeLink() {
		return slideThreeLink;
	}
}
