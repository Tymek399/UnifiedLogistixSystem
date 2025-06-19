package pl.logistic.unifiedlogistixsystem.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.logistic.unifiedlogistixsystem.enums.MissionPriority;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateMissionDTO {
    @NotBlank(message = "Mission name is required")
    private String name;

    private String description;

    @NotNull(message = "Priority is required")
    private MissionPriority priority;

    @NotNull(message = "Start date is required")
    @Future(message = "Start date must be in the future")
    private LocalDateTime startDate;

    private LocalDateTime endDate;

    @Min(value = 1, message = "Estimated duration must be at least 1 minute")
    private Integer estimatedDuration;

    @NotNull(message = "Operator ID is required")
    private Long operatorId;

    private Set<Long> assignedUnitIds;
}
