package pl.logistic.unifiedlogistixsystem.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import pl.logistic.unifiedlogistixsystem.dto.CreateUserDto;
import pl.logistic.unifiedlogistixsystem.dto.UpdateUserDto;
import pl.logistic.unifiedlogistixsystem.dto.UserDto;
import pl.logistic.unifiedlogistixsystem.model.User;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDTO(User user);

    List<UserDto> toDTOList(List<User> users);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "lastLogin", ignore = true)
    @Mapping(target = "managedMissions", ignore = true)
    @Mapping(target = "isActive", constant = "true")
    User toEntity(CreateUserDto createUserDTO);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "username", ignore = true)
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "lastLogin", ignore = true)
    @Mapping(target = "managedMissions", ignore = true)
    void updateEntityFromDTO(UpdateUserDto updateUserDTO, @MappingTarget User user);
}
