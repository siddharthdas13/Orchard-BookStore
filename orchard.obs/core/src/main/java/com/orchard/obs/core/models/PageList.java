package com.orchard.obs.core.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.day.cq.wcm.api.Page;

public class PageList 
{

	String title;
	String path;
	List<PageList> childPages;
	
	public PageList() {
		super();
	}
	public PageList(String title, String path, List<PageList> childPages) {
		super();
		this.title = title;
		this.path = path;
		this.childPages = new ArrayList<>(childPages);
	}
	
	public PageList(String title, String path) {
		super();
		this.title = title;
		this.path = path;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	public List<PageList> getChildPages() {
		return Collections.unmodifiableList(childPages);
	}
	public void setChildPages(List<PageList> childPages) {
		this.childPages = childPages;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
}