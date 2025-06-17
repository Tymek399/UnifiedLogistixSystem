package pl.logistic.unifiedlogistixsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocationLogDto {
    private Long unitId;
    private LocalDateTime timestamp;
    private Double latitude;
    private Double longitude;
}
