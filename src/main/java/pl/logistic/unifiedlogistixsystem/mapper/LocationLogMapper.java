package pl.logistic.unifiedlogistixsystem.mapper;

import org.mapstruct.*;
import pl.logistic.unifiedlogistixsystem.dto.LocationLogDto;
import pl.logistic.unifiedlogistixsystem.model.LocationLog;
import pl.logistic.unifiedlogistixsystem.model.Unit;

@Mapper(componentModel = "spring")
public interface LocationLogMapper {

    @Mapping(source = "unit.id", target = "unitId")
    LocationLogDto toDto(LocationLog locationLog);

    @Mapping(target = "unit", expression = "java(unitFromId(dto.getUnitId()))")
    @Mapping(target = "id", ignore = true)
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
