package pl.logistic.unifiedlogistixsystem.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.logistic.unifiedlogistixsystem.enums.LocationSource;
import pl.logistic.unifiedlogistixsystem.enums.OperationalStatus;
import pl.logistic.unifiedlogistixsystem.enums.UnitStatus;
import pl.logistic.unifiedlogistixsystem.enums.UnitType;

import java.time.LocalDateTime;



@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UnitDto {
    private Long id;
    private String name;
    private String callSign;
    private UnitType type;
    private UnitStatus status;
    private OperationalStatus operationalStatus;
    private Double latitude;
    private Double longitude;
    private Double fuelLevel;
    private Integer capacity;
    private Integer personnelCount;
    private LocalDateTime lastContact;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private GPSDeviceDTO gpsDevice;
}

