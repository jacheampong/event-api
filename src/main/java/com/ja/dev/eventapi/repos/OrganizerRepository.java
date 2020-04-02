package com.ja.dev.eventapi.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ja.dev.eventapi.entities.Organizer;

public interface OrganizerRepository extends JpaRepository<Organizer, Long> {

}
