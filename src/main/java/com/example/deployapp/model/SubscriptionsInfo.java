package com.example.deployapp.model;

import java.util.ArrayList;
import java.util.List;

public class SubscriptionsInfo {
	
	private List<String> subscribe = new ArrayList<>();
	
	private List<String> unsubscribe = new ArrayList<>();

	public List<String> getSubscribe() {
		return subscribe;
	}

	public void setSubscribe(List<String> subscribe) {
		this.subscribe = subscribe;
	}

	public List<String> getUnsubscribe() {
		return unsubscribe;
	}

	public void setUnsubscribe(List<String> unsubscribe) {
		this.unsubscribe = unsubscribe;
	}
	
	

}
