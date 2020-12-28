package com.orchard.obs.core.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.jackrabbit.api.security.user.UserManager;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.scripting.SlingScriptHelper;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.cq.social.community.api.CommunityContext;
import com.adobe.granite.security.user.UserManagementService;
import com.day.cq.notification.api.Template;
import com.day.cq.wcm.api.LanguageManager;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageFilter;
import com.day.cq.wcm.api.PageManager;

@Model(adaptables = {Resource.class})
public class Header 
{
	Logger logger = LoggerFactory.getLogger(Header.class);

    private List<PageList> pages;

    @SlingObject
    private ResourceResolver resourceResolver;
    
    @PostConstruct
    protected void init() {
        PageManager pageManager = resourceResolver.adaptTo(PageManager.class);
        Page currentPage = pageManager.getPage("/content/obs/india/english"); // Add Your Path
        Iterator<Page> childPages = currentPage.listChildren(null, false);
                
        pages = new ArrayList<PageList>();
        
        while(childPages.hasNext()) {
        	Page page = childPages.next();
            pages.add(new PageList(page.getTitle(), page.getPath() ,child(page) ));
            logger.info("Err : " + pages.size());
        }
    }
    public List<PageList> child(Page page)
    {

    	List<PageList> childPages;

        PageManager pageManager = resourceResolver.adaptTo(PageManager.class);
       
        	Page currentChild =pageManager.getPage(page.getPath());
            Iterator<Page> childPageList = currentChild.listChildren(null, false);
            childPages= new ArrayList<PageList>();
            
            
            while(childPageList.hasNext())
            {
            	Page page1 = childPageList.next();
            	childPages.add(new PageList(page1.getTitle(),page1.getPath()));
                logger.info("Err : " + childPages.size());

            }

        	
        return childPages;
    }
    public List<PageList> getPages() {
    	
    	return pages;
    }
    
   
}

	 