package com.deskbooking.deskbooking.dto;

import com.deskbooking.deskbooking.model.Desk;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeskDTO {
    private String name;

    public DeskDTO(Desk desk){
        this.name = desk.getName();
    }
}
