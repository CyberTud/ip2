package com.deskbooking.deskbooking.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Desk {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer deskId;

    @NotNull
    private String name;


}
