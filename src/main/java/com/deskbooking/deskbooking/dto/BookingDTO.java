package com.deskbooking.deskbooking.dto;

import com.deskbooking.deskbooking.model.Booking;
import com.deskbooking.deskbooking.model.Desk;
import com.deskbooking.deskbooking.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDTO {
    private String emailUser;
    private String nameDesk;
    private String dateBooking;
    private Date checkIn;
    private Date checkOut;

    public BookingDTO(User user, Desk desk,Booking booking){
        this.emailUser = user.getEmail();
        this.nameDesk = desk.getName();
        this.checkIn = booking.getCheckIn();
        this.checkOut = booking.getCheckOut();
    }
}
