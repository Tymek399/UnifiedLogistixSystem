package pl.logistic.unifiedlogistixsystem.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import pl.logistic.unifiedlogistixsystem.dto.CreateUnitDTO;
import pl.logistic.unifiedlogistixsystem.dto.UnitDto;
import pl.logistic.unifiedlogistixsystem.model.Unit;

import java.util.List;


@Mapper(componentModel = "spring", uses = {GPSDeviceMapper.class})
public interface UnitMapper {

    UnitDto toDTO(Unit unit);

    List<UnitDto> toDTOList(List<Unit> units);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "lastContact", ignore = true)
    @Mapping(target = "locationLogs", ignore = true)
    @Mapping(target = "missions", ignore = true)
    @Mapping(target = "gpsDevice", ignore = true)
    Unit toEntity(CreateUnitDTO createUnitDTO);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", ignore = true)
    @Mapping(target = "callSign", ignore = true)
    @Mapping(target = "type", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "locationLogs", ignore = true)
    @Mapping(target = "missions", ignore = true)
    @Mapping(target = "gpsDevice", ignore = true)
    void updateEntityFromDTO(UpdateUnitDTO updateUnitDTO, @MappingTarget Unit unit);
}
