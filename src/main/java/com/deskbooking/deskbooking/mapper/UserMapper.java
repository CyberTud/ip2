package com.deskbooking.deskbooking.mapper;
import org.mapstruct.Mapper;
import com.deskbooking.deskbooking.dto.UserDTO;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toUserDTO(User user);
}
