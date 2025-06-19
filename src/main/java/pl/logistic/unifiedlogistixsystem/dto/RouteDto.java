package pl.logistic.unifiedlogistixsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.logistic.unifiedlogistixsystem.enums.RouteStatus;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RouteDto {
    private Long id;
    private String name;
    private Long missionId;
    private Double startLatitude;
    private Double startLongitude;
    private Double endLatitude;
    private Double endLongitude;
    private List<WaypointDTO> waypoints;
    private Integer estimatedDuration;
    private Integer actualDuration;
    private Double distance;
    private RouteStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

