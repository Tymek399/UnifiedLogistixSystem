package pl.logistic.unifiedlogistixsystem.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.logistic.unifiedlogistixsystem.dto.UnitDto;
import pl.logistic.unifiedlogistixsystem.model.Unit;

@Mapper(componentModel = "spring")
public interface UnitMapper {

    UnitDto toDto(Unit entity);


    Unit toEntity(UnitDto dto);
}
