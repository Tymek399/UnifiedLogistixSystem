package pl.logistic.unifiedlogistixsystem.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;

@Entity
@Table(name = "system_health")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SystemHealth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "component_name", nullable = false)
    private String componentName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private HealthStatus status;

    @Column(name = "response_time")
    private Long responseTime; // ms

    @Column(name = "error_message")
    private String errorMessage;

    @Column(name = "checked_at", nullable = false)
    private LocalDateTime checkedAt;

    @Column(name = "metadata", columnDefinition = "TEXT")
    private String metadata; // JSON

    @PrePersist
    protected void onCreate() {
        checkedAt = LocalDateTime.now();
    }
}
