package com.travel.portal.repository;

import com.travel.portal.entity.Rooms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("roomsRepository")
public interface RoomsRepository extends JpaRepository<Rooms, Long> {
}
