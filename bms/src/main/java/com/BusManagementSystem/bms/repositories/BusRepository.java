package com.BusManagementSystem.bms.repositories;

import com.BusManagementSystem.bms.entities.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BusRepository extends JpaRepository<Bus, Long> {
    @Query("SELECT b FROM Bus b WHERE b.model = :model")
    Optional<Bus> findByModel(String model);

    @Query("SELECT b FROM Bus b WHERE b.capacity = :capacity")
    List<Bus> findByCapacity(Integer capacity);
//    @Query("SELECT b FROM Bus b WHERE b.amenity = :amenity")
    List<Bus> findByAmenitiesContaining(String amenity);

//    List<Bus> findBySchedulesBetween(LocalDate startDate, LocalDate endDate);
}
