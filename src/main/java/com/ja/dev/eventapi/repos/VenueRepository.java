package com.ja.dev.eventapi.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ja.dev.eventapi.entities.Venue;

public interface VenueRepository extends JpaRepository<Venue, Long> {

}
