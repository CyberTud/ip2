package com.deskbooking.deskbooking.repository;

import com.deskbooking.deskbooking.model.Booking;
import com.deskbooking.deskbooking.model.Desk;
import com.deskbooking.deskbooking.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking,Integer> {
    Optional<List<Booking>> findAllByUserId(Integer userId);

    Optional<List<Booking>> findAllByDeskId(Integer deskId);

    @Modifying
    @Transactional
    @Query("UPDATE Booking b SET b.canceled = 1 WHERE b.bookingId = :id")
    void deleteById(Integer id);
}
