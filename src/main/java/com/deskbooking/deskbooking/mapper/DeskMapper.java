package com.deskbooking.deskbooking.mapper;

import com.deskbooking.deskbooking.dto.DeskDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DeskMapper {
    DeskDTO toDeskDTO(Desk desk);
}
