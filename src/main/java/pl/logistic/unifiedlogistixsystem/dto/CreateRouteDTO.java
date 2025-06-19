package pl.logistic.unifiedlogistixsystem.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateRouteDTO {
    @NotBlank(message = "Route name is required")
    private String name;

    @NotNull(message = "Mission ID is required")
    private Long missionId;

    @NotNull(message = "Start latitude is required")
    @DecimalMin(value = "-90.0")
    @DecimalMax(value = "90.0")
    private Double startLatitude;

    @NotNull(message = "Start longitude is required")
    @DecimalMin(value = "-180.0")
    @DecimalMax(value = "180.0")
    private Double startLongitude;

    @NotNull(message = "End latitude is required")
    @DecimalMin(value = "-90.0")
    @DecimalMax(value = "90.0")
    private Double endLatitude;

    @NotNull(message = "End longitude is required")
    @DecimalMin(value = "-180.0")
    @DecimalMax(value = "180.0")
    private Double endLongitude;

    private List<CreateWaypointDTO> waypoints;
    private Integer estimatedDuration;
}
