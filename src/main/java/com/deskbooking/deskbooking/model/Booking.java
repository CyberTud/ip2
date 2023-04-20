package com.deskbooking.deskbooking.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookingId;

    @NotNull
    private Integer userId;

    @NotNull
    private Integer deskId;

    @NotNull
    private Date checkIn;

    @NotNull
    private Date checkOut;

    @NotNull
    private Integer canceled = 0;
}
