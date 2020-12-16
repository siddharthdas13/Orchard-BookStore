package com.orchard.obs.core.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

public class UrlHelper
{
	 private static final Logger log = LoggerFactory.getLogger(UrlHelper.class);
	    private static final String RT_REDIRECT = "obs/components/structure/page";
	    private static final String PN_REDIRECT_TARGET = "cq:redirectTarget";
	    
	    public static boolean isRedirectPage(Page page) {
	        boolean isRedirect = false;
	        Resource contentResource = page.getContentResource();
	        if (contentResource != null) {
	            isRedirect = contentResource.isResourceType(RT_REDIRECT);
	        } else {
	            log.error("Can't get content resource of page {}", page.getPath());
	        }
	        return isRedirect;
	    }
	    
	    public static Page resolveRedirectPage(Page page, PageManager pageManager) {
	        Page redirectTarget = page;
	        if (isRedirectPage(page)) {
	            Resource contentResource = page.getContentResource();
	            ValueMap valueMap = contentResource.getValueMap();
	            String redirectPagePath = valueMap.get(PN_REDIRECT_TARGET, StringUtils.EMPTY);
	            Page resolvedPage = pageManager.getPage(redirectPagePath);
	            if (resolvedPage != null) {
	                redirectTarget = resolvedPage;
	            }
	        }
	        return redirectTarget;
	    }

}
