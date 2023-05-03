package com.deskbooking.deskbooking.mapper;

import com.deskbooking.deskbooking.dto.DeskDTO;
import com.deskbooking.deskbooking.model.Desk;
import org.mapstruct.Mapper;

import java.time.LocalDateTime;
import java.util.List;

@Mapper(componentModel = "spring")
public interface DeskMapper {
    DeskDTO toDeskDTO(Desk desk, List<LocalDateTime> freeHours);
}
