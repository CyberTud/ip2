package com.deskbooking.deskbooking.controller;

import com.deskbooking.deskbooking.dto.BookingDTO;
import com.deskbooking.deskbooking.exception.NoBookings;
import com.deskbooking.deskbooking.exception.NoDeskFound;
import com.deskbooking.deskbooking.exception.NoUserFound;
import com.deskbooking.deskbooking.model.Booking;
import com.deskbooking.deskbooking.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("booking")
public class BookingController {
    private final BookingService bookingService;

    @PostMapping("/create")
    public Booking createBooking(@RequestBody Booking booking){
        return bookingService.createBooking(booking);
    }
//    @PostMapping
//    public Booking createBooking(@RequestParam String token,@RequestParam Integer deskId,@RequestParam String daySelection,@RequestParam String hours){
//        return bookingService.createBooking(token,deskId,daySelection,hours);
//    }

    @GetMapping("/getAll")
    public List<Booking> getAllBookings(){
        return bookingService.getAllBookings();
    }

    @GetMapping("/getAllByUser/{userId}")
    public List<Booking> getAllBookigsByUser(@PathVariable Integer userId) throws NoBookings, NoUserFound {
        System.out.println(userId);
        return bookingService.getAllBookigsByUser(userId);
    }

    @GetMapping("/getAllByDesk/{deskId}")
    public List<Booking> getAllBookigsByDesk(@PathVariable Integer deskId) throws NoBookings, NoDeskFound {
        return bookingService.getAllBookingsByDesk(deskId);
    }

//    @PutMapping("/addUser/{bookingId}/{userId}")
//    public void addUser(@PathVariable Integer bookingId,@PathVariable Integer userId) throws NoUserFound, NoBookings {
//        bookingService.addUser(bookingId,userId);
//    }
//
//    @PutMapping("/addDesk/{bookingId}/{deskId}")
//    public void addDesk(@PathVariable Integer bookingId,@PathVariable Integer deskId) throws NoBookings, NoDeskFound {
//        bookingService.addDesk(bookingId,deskId);
//    }

    @GetMapping("/desksByDate")
    public List<Booking> getBookingsByDate(@RequestParam String date){
        return bookingService.showBookingsForADate(date);
    }

    @PutMapping("/deleteBooking/{bookingId}")
    public void deleteBookingById(@PathVariable Integer bookingId){
        bookingService.deleteBooking(bookingId);
    }

    @GetMapping("/bookings")
    public List<BookingDTO> getBooking(){
        return bookingService.getBooking();
    }
}
