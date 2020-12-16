package com.orchard.obs.core.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.wcm.api.NameConstants;
import com.day.cq.wcm.api.Page;

public class obsHelper
{

	private static final Logger LOGGER = LoggerFactory.getLogger(obsHelper.class);
    private static final String PROP_NAV_ROOT = "navRoot";
    
    public static Page findRoot(Page resourcePage) {
        Page rootPage = resourcePage;
        while(rootPage != null && !isRoot(rootPage)) {
            rootPage = rootPage.getParent();
        }
        return rootPage;
    }

    public static boolean isRoot(Page page) {
        Resource res = page.getContentResource();
        if (res == null) {
            return false;
        }
        ValueMap vm = res.getValueMap();
        return vm.get(PROP_NAV_ROOT, false);
    }

    public static String getTitle(final Resource resource, final Page page) {
        if (resource != null) {
            final ValueMap properties = resource.adaptTo(ValueMap.class);
            if (properties != null) {
                final String title = properties.get(NameConstants.PN_TITLE, String.class);
                if (StringUtils.isNotBlank(title)) {
                    return title;
                } else {
                    return getPageTitle(page);
                }
            }
        } else {
            LOGGER.debug("Provided resource argument is null");
        }
        return null;
    }
    public static String getPageTitle(final Page page) {
        if (page != null) {
            final String title = page.getPageTitle();
            if (StringUtils.isBlank(title)) {
                return getTitle(page);
            }
            return title;
        } else {
            LOGGER.debug("Provided page argument is null");
            return null;
        }
    }
    
    public static String getTitle(final Page page) {
        if (page != null) {
            final String title = page.getTitle();
            if (StringUtils.isBlank(title)) {
                return page.getName();
            }
            return title;
        } else {
            LOGGER.debug("Provided page argument is null");
            return null;
        }
    }

}
