package com.deskbooking.deskbooking.dto;

import com.deskbooking.deskbooking.model.Booking;
import com.deskbooking.deskbooking.model.Desk;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeskDTO {
    private String name;
    private Integer fullyBooked = 2;

    public DeskDTO(Desk desk, List<LocalDateTime> freeHours){
        this.name = desk.getName();
        if (freeHours.size() == 0){
            this.fullyBooked = 1;
        }
        else {
            if (freeHours.size() == 13){
                this.fullyBooked = 0;
            }
        }
    }
}
