package pl.logistic.unifiedlogistixsystem.mapper;

import org.mapstruct.Mapper;
import pl.logistic.unifiedlogistixsystem.dto.UserDto;
import pl.logistic.unifiedlogistixsystem.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
    User toEntity(UserDto dto);
}
