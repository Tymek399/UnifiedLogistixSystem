package pl.logistic.unifiedlogistixsystem.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.logistic.unifiedlogistixsystem.enums.Role;

import java.time.LocalDateTime;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserDto {
    private String email;
    private String firstName;
    private String lastName;
    private Role role;
    private Boolean isActive;
}
