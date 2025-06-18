package pl.logistic.unifiedlogistixsystem.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class MissionDto {
    private Long id;
    private String name;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String status;
    private Long unitId;      // klucz obcy
    private String unitName;  // opcjonalnie do wyświetlania nazwy jednostki
}
