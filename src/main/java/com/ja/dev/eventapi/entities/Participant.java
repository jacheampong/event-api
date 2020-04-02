package com.ja.dev.eventapi.entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Participant extends AbstractEntity {

	private String email;
	private Boolean checkedIn;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(referencedColumnName = "ID", nullable = false, updatable = false)
	private Event event;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getCheckedIn() {
		return checkedIn;
	}

	public void setCheckedId(Boolean checkedIn) {
		this.checkedIn = checkedIn;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}
	
	public Long getResourceId() {
		return id;
	}
	
	@Override
	public boolean equals(Object obj) {
		return Objects.equals(id, ((Participant) obj).id);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

}
