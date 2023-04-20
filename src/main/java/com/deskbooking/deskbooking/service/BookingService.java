package com.deskbooking.deskbooking.service;

import com.deskbooking.deskbooking.dto.BookingDTO;
import com.deskbooking.deskbooking.exception.NoBookings;
import com.deskbooking.deskbooking.exception.NoDeskFound;
import com.deskbooking.deskbooking.exception.NoUserFound;
import com.deskbooking.deskbooking.mapper.BookingMapper;
import com.deskbooking.deskbooking.model.Booking;
import com.deskbooking.deskbooking.model.Desk;
import com.deskbooking.deskbooking.model.User;
import com.deskbooking.deskbooking.repository.BookingRepository;
import com.deskbooking.deskbooking.repository.DeskRepository;
import com.deskbooking.deskbooking.repository.UserRepository;
import com.deskbooking.deskbooking.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingService {
    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final DeskRepository deskRepository;
    private final BookingMapper bookingMapper;

    public Booking createBooking(Booking booking){
        return bookingRepository.save(booking);
    }
//    public Booking createBooking(String token, Integer deskId, String daySelection, String hours){
//        String email = jwtUtil.extractUsername(token);
//        Booking booking = new Booking();
//        booking.setUserId(userRepository.findByEmail(email).getUserId());
//        booking.setDeskId(deskId);
//        List<Booking> bookings= showBookingsForADate(daySelection);
//        for (Booking b: bookings
//             ) {
//            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//            System.out.println(formatter.format(b.getCheckIn()));
//        }
//List<Booking> bookings= showBookingsForADate(daySelection); //varianta buna
//        for (Booking b: bookings
//             ) {
////            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//        Date date = b.getCheckIn();
//        Locale locale = new Locale("ro", "RO");
//        DateFormat dateFormat = DateFormat.getTimeInstance(DateFormat.DEFAULT, locale);
//        String date2 = dateFormat.format(date);
//        System.out.println(date2);
//    }
//        return bookingRepository.save(booking);
//    }

    public List<Booking> getAllBookings(){
        return bookingRepository.findAll();
    }

    public List<Booking> getAllBookigsByUser(Integer userId) throws NoBookings, NoUserFound {
        User user = userRepository.findById(userId).orElseThrow(NoUserFound::new);
        return bookingRepository.findAllByUserId(userId).orElseThrow(NoBookings::new);
    }

    public List<Booking> getAllBookingsByDesk(Integer deskId) throws NoBookings, NoDeskFound {
       Desk desk = deskRepository.findById(deskId).orElseThrow(NoDeskFound::new);
        return bookingRepository.findAllByDeskId(deskId).orElseThrow(NoBookings::new);
    }

//    public void addUser(Integer bookingId, Integer userId) throws NoBookings, NoUserFound {
//        Booking booking = bookingRepository.findById(bookingId).orElseThrow(NoBookings::new);
//        User user = userRepository.findById(userId).orElseThrow(NoUserFound::new);
//        booking.setUser(user);
//        bookingRepository.save(booking);
//    }
//
//    public void addDesk(Integer bookingId, Integer deskId) throws NoBookings, NoDeskFound {
//        Booking booking = bookingRepository.findById(bookingId).orElseThrow(NoBookings::new);
//       Desk desk = deskRepository.findById(deskId).orElseThrow(NoDeskFound::new);
//        booking.setDesk(desk);
//        bookingRepository.save(booking);
//    }

    public List<Booking> showBookingsForADate(String date){
//        List<Booking> bookings = getAllBookings();
//        List<Booking> bookingsFromDate = new ArrayList<>();
//        for (Booking booking:bookings) {
//            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//            String dateIn = formatter.format(booking.getCheckIn());
//            if (dateIn.equals(date))
//            {
//                bookingsFromDate.add(booking);
//            }
//        }
//        return bookingsFromDate;
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return getAllBookings().stream()
                .filter(booking -> {
                    return formatter.format(booking.getCheckIn()).equals(date);
                })
                .collect(Collectors.toList());
    }

    public void deleteBooking(Integer bookingId){
        bookingRepository.deleteById(bookingId);
    }

    public List<BookingDTO> getBooking(){
//        Booking booking = bookingRepository.findById(id).get();
//        User user = userRepository.findById(booking.getUserId()).get();
//        Desk desk = deskRepository.findById(booking.getDeskId()).get();
//        BookingDTO bookingDTO = bookingMapper.toBookingDTO(user, desk,booking);
//        return bookingMapper.toBookingDTO(user, desk,booking);
        return bookingRepository.findAll().stream()
                .map(booking -> {
                   return bookingMapper.toBookingDTO(userRepository.findById(booking.getUserId()).get(),deskRepository.findById(booking.getDeskId()).get(),booking);
                })
                .collect(Collectors.toList());
    }
}
