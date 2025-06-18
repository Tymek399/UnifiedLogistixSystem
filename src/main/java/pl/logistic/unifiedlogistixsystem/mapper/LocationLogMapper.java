package pl.logistic.unifiedlogistixsystem.mapper;

import org.mapstruct.*;
import pl.logistic.unifiedlogistixsystem.dto.LocationLogDto;
import pl.logistic.unifiedlogistixsystem.model.LocationLog;
import pl.logistic.unifiedlogistixsystem.model.Unit;

@Mapper(componentModel = "spring")
public interface LocationLogMapper {

    LocationLogDto toDto(LocationLog entity);


    LocationLog toEntity(LocationLogDto dto);

    default Unit unitFromId(Long id) {
        if (id == null) {
            return null;
        }
        Unit unit = new Unit();
        unit.setId(id);
        return unit;
    }
}

