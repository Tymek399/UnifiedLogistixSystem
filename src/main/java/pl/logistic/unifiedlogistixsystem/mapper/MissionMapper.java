package pl.logistic.unifiedlogistixsystem.mapper;

import org.mapstruct.*;
import pl.logistic.unifiedlogistixsystem.dto.MissionDto;
import pl.logistic.unifiedlogistixsystem.model.Mission;
import pl.logistic.unifiedlogistixsystem.model.Unit;

@Mapper(componentModel = "spring")
public interface MissionMapper {

    @Mapping(source = "unit.id", target = "unitId")
    MissionDto toDto(Mission mission);

    @Mapping(target = "unit", expression = "java(unitFromId(dto.getUnitId()))")
    @Mapping(target = "id", ignore = true)  // ignoruj id w DTO
    Mission toEntity(MissionDto dto);

    default Unit unitFromId(Long id) {
        if (id == null) {
            return null;
        }
        Unit unit = new Unit();
        unit.setId(id);
        return unit;
    }
}
