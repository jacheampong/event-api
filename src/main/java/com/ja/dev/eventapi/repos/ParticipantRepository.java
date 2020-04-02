package com.ja.dev.eventapi.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ja.dev.eventapi.entities.Participant;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {

}
