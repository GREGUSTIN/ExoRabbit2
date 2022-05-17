package be.technifutur.userService.mapper;

import be.technifutur.userService.dto.UserDTO;
import be.technifutur.userService.entity.User;


public class UserMapper {

    public static UserDTO toDto(User entity){
        if(entity == null)
            return null;

        return new UserDTO(entity.getUsername(), null,entity.getRoles());

    }

}
