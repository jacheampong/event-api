package com.ja.dev.eventapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ja.dev.eventapi.entities.Event;
import com.ja.dev.eventapi.repos.EventRepository;

@RepositoryRestController
@RequestMapping("/events")
public class EventKickOffController {
	
	@Autowired
	private EventRepository eventRepository;
	
	@PostMapping("/start/{id}")
	public ResponseEntity start(@PathVariable Long id) {
		
		Event event = eventRepository.findById(id).get();
		if (!eventRepository.findById(id).isPresent()) {
			throw new ResourceNotFoundException();
		} else {
			event.setStarted(true);
			eventRepository.save(event);
		}
		
		return ResponseEntity.ok(event.getName() + " has started");
	}

}
