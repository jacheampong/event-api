package com.ja.dev.eventapi.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.ja.dev.eventapi.entities.Event;
import java.lang.String;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
	
	List<Event> findByName(@Param("name") String name);

}
