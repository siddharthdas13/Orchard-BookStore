package com.orchard.obs.core.models;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;

@Model(adaptables = Resource.class)
public class BannerModel {
	
    @Inject @Optional
    public String bgimage; // corresponds to the node in the dialog named bgimage
     
    @Inject @Optional
    public String position; // corresponds to the node in the dialog named position
     
     
    @Inject @Optional
    public String heading; // corresponds to the node in the dialog named heading
     
    @Inject @Optional
    public String fontsize; // corresponds to the node in the dialog named fontsize
     
     
    @Inject @Optional
    public String description; // corresponds to the node in the dialog named description
     
    @Inject @Optional
    public String buttontext; // corresponds to the node in the dialog named buttontext
     
    @Inject @Optional
    public String hreflink; // corresponds to the node in the dialog named hreflink
     
    @Inject @Optional
    public String textcolor; // corresponds to the node in the dialog named textcolor
    
    private String m_bgimage  ; 
     
    private String m_position;
     
    private String m_heading;
     
    private String m_fontsize ;
     
    private String m_description;
     
    private String m_buttontext ;
     
    private String m_hreflink ;
  
    private String m_textcolor;
    @PostConstruct
    protected void init() {
        m_bgimage=bgimage;  
        m_position = position; 
        m_heading = heading; 
        m_fontsize= fontsize;
        m_description =description; 
        m_buttontext = buttontext;
        m_hreflink=hreflink;
        m_textcolor=textcolor;
    } 
     
    public String getBackimage() {
        return m_bgimage;
    }
     
    public String getPosition() {
        return m_position ;
    }
     
        
    public String getHeading() {
        return m_heading;
    }
    
    public String getFontsize() {
        return m_fontsize;
    }
     
    public String getDescription() {
        return m_description;
    }
     
    public String getButtontext() {
        return m_buttontext;
    }
     
    public String getHreflink() {
        return m_hreflink;
    }

	public String getTextcolor() {
		return m_textcolor;
	}

}

