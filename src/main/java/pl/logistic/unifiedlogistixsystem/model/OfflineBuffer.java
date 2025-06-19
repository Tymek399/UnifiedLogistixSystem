package pl.logistic.unifiedlogistixsystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "offline_buffer")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OfflineBuffer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "unit_id", nullable = false)
    private Long unitId;

    @Enumerated(EnumType.STRING)
    @Column(name = "operation_type", nullable = false)
    private OperationType operationType;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String data; // JSON payload

    @Column(nullable = false)
    private LocalDateTime timestamp;

    @Column(name = "synced")
    private Boolean synced = false;

    @Column(name = "retry_count")
    private Integer retryCount = 0;

    @Column(name = "last_retry")
    private LocalDateTime lastRetry;

    @Column(name = "error_message")
    private String errorMessage;

    @PrePersist
    protected void onCreate() {
        if (timestamp == null) {
            timestamp = LocalDateTime.now();
        }
    }
}
