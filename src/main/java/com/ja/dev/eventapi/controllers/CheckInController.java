package com.ja.dev.eventapi.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ja.dev.eventapi.controllers.exceptions.AlreadyCheckedInException;
import com.ja.dev.eventapi.entities.Participant;
import com.ja.dev.eventapi.repos.ParticipantRepository;

@RepositoryRestController
@RequestMapping("/events")
public class CheckInController {
	
	@Autowired
	private ParticipantRepository participantRepository;
	
	@PostMapping("/checkin/{id}")
	public ResponseEntity<PersistentEntityResource> checkIn(@PathVariable Long id, PersistentEntityResourceAssembler assembler) {
		
		Optional<Participant> participant = participantRepository.findById(id);
				
			participant.ifPresent(p -> {
				if (p.getCheckedIn()) {
					throw new AlreadyCheckedInException();
				}
				
				p.setCheckedId(true);
				participantRepository.save(p);
				
			});
		
		return ResponseEntity.ok(assembler.toFullResource(participant.get()));
	}

}
