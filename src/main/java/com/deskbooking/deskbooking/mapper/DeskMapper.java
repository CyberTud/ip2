package com.deskbooking.deskbooking.mapper;

import com.deskbooking.deskbooking.dto.DeskDTO;
import com.deskbooking.deskbooking.dto.UserDTO;
import com.deskbooking.deskbooking.model.Desk;
import com.deskbooking.deskbooking.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DeskMapper {
    DeskDTO toDeskDTO(Desk desk);
}
