package com.deskbooking.deskbooking.mapper;

import com.deskbooking.deskbooking.dto.BookingDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookingMapper {
    BookingDTO toBookingDTO(User user, Desk desk, Booking booking);
}
