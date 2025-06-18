package pl.logistic.unifiedlogistixsystem.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.logistic.unifiedlogistixsystem.dto.MissionDto;
import pl.logistic.unifiedlogistixsystem.model.Mission;
import pl.logistic.unifiedlogistixsystem.model.Unit;

@Mapper(componentModel = "spring")
public interface MissionMapper {


    MissionDto toDto(Mission mission);

    Mission toEntity(MissionDto dto);

    default Unit unitFromId(Long id) {
        if (id == null) return null;
        Unit unit = new Unit();
        unit.setId(id);
        return unit;
    }
}
