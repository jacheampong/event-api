package com.ja.dev.eventapi.entities;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Organizer extends AbstractEntity {
	
	@OneToMany(mappedBy = "organizer")
	private Set<Event> events;

	public Set<Event> getEvents() {
		return events;
	}

	public void setEvents(Set<Event> events) {
		this.events = events;
	}
	
	public Long getResourceId() {
		return id;
	}
	
	@Override
	public boolean equals(Object obj) {
		return Objects.equals(id, ((Organizer) obj).id);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	
}
