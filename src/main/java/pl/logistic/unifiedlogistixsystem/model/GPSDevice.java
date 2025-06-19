package pl.logistic.unifiedlogistixsystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "gps_devices")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GPSDevice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "device_id", unique = true, nullable = false)
    private String deviceId;

    @Column(unique = true, nullable = false)
    private String imei;

    @Column(name = "sim_number")
    private String simNumber;

    @OneToOne(mappedBy = "gpsDevice")
    private Unit assignedUnit;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private GPSStatus status;

    @Column(name = "last_contact")
    private LocalDateTime lastContact;

    @Column(name = "battery_level")
    private Integer batteryLevel;

    @Column(name = "signal_strength")
    private Integer signalStrength;

    @Column(name = "encryption_key")
    private String encryptionKey;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}