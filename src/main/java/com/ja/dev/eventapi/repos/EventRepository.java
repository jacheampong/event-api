package com.ja.dev.eventapi.repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.ja.dev.eventapi.entities.Event;
import java.lang.String;

public interface EventRepository extends JpaRepository<Event, Long> {
	
	Page<Event> findByName(@Param("name") String name, Pageable pageable);

}
