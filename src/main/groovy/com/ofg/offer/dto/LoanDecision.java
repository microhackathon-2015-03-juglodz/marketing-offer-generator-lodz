package com.ofg.offer.dto;

import javax.persistence.Entity;

public class LoanDecision {
	private Person person;
	private String decision;
	
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public String getDecision() {
		return decision;
	}
	public void setDecision(String decision) {
		this.decision = decision;
	}
	
	
}
