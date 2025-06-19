package pl.logistic.unifiedlogistixsystem.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.logistic.unifiedlogistixsystem.enums.LocationSource;
import pl.logistic.unifiedlogistixsystem.enums.MissionPriority;
import pl.logistic.unifiedlogistixsystem.enums.MissionStatus;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MissionDto{
    private Long id;
    private String name;
    private String description;
    private MissionStatus status;
    private MissionPriority priority;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Integer estimatedDuration;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private UserDto operator;
    private Set<UnitDto> assignedUnits;
    private Set<RouteDto> routes;
}

