package pl.logistic.unifiedlogistixsystem.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.logistic.unifiedlogistixsystem.enums.OperationalStatus;
import pl.logistic.unifiedlogistixsystem.enums.UnitStatus;
import pl.logistic.unifiedlogistixsystem.enums.UnitType;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateUnitDTO {
    @NotBlank(message = "Unit name is required")
    private String name;

    @NotBlank(message = "Call sign is required")
    private String callSign;

    @NotNull(message = "Unit type is required")
    private UnitType type;

    @NotNull(message = "Initial status is required")
    private UnitStatus status;

    @NotNull(message = "Operational status is required")
    private OperationalStatus operationalStatus;

    @NotNull(message = "Latitude is required")
    @DecimalMin(value = "-90.0")
    @DecimalMax(value = "90.0")
    private Double latitude;

    @NotNull(message = "Longitude is required")
    @DecimalMin(value = "-180.0")
    @DecimalMax(value = "180.0")
    private Double longitude;

    @Min(value = 0, message = "Fuel level cannot be negative")
    @Max(value = 100, message = "Fuel level cannot exceed 100%")
    private Double fuelLevel;

    @Min(value = 0, message = "Capacity cannot be negative")
    private Integer capacity;

    @Min(value = 0, message = "Personnel count cannot be negative")
    private Integer personnelCount;
}
