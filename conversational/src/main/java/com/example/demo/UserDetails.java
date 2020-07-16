package com.example.demo;

import java.util.Date;

public class UserDetails {
	
private String name;
	
	private String date;
	
	private String transition;
	
	private String nextTransition;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTransition() {
		return transition;
	}

	public void setTransition(String transition) {
		this.transition = transition;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public String getNextTransition() {
		return nextTransition;
	}

	public void setNextTransition(String nextTransition) {
		this.nextTransition = nextTransition;
	}

}
