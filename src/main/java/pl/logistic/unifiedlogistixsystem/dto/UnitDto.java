package pl.logistic.unifiedlogistixsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UnitDto {
    private String name;
    private String type;
    private String status;
    private Double latitude;
    private Double longitude;
}
