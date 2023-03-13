package com.BusManagementSystem.bms.repositories;

import com.BusManagementSystem.bms.entities.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Long> {
}
