package com.ja.dev.eventapi.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ja.dev.eventapi.entities.Event;

public interface EventRepository extends JpaRepository<Event, Long> {

}
