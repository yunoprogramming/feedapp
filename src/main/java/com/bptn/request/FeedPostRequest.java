package com.bptn.request;


public class FeedPostRequest {

	String fromDate;
	String toDate;
	String queryKeyword;
	String username; 
	
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	public String getQueryKeyword() {
		return queryKeyword;
	}
	public void setQueryKeyword(String queryKeyword) {
		this.queryKeyword = queryKeyword;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}
