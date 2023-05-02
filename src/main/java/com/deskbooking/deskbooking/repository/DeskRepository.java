package com.deskbooking.deskbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DeskRepository extends JpaRepository<Desk,Integer> {
    Desk findDeskByName(String name);
}
