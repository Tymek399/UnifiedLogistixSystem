package pl.logistic.unifiedlogistixsystem.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "units")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "call_sign", unique = true)
    private String callSign;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UnitType type;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UnitStatus status;

    @Column(nullable = false)
    private Double latitude;

    @Column(nullable = false)
    private Double longitude;

    @Column(nullable = false)
    private Double altitude = 0.0;

    @Column(name = "fuel_level")
    private Double fuelLevel;

    @Column(name = "max_fuel_capacity")
    private Double maxFuelCapacity;

    @Column(name = "crew_capacity")
    private Integer crewCapacity;

    @Column(name = "current_crew")
    private Integer currentCrew;

    @Column(name = "equipment_status")
    private String equipmentStatus;

    @Column(name = "last_contact")
    private LocalDateTime lastContact;

    @Column(name = "is_operational")
    private Boolean isOperational = true;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "unit", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<LocationLog> locationHistory = new ArrayList<>();

    @ManyToMany(mappedBy = "assignedUnits")
    private List<Mission> missions = new ArrayList<>();

    @OneToOne(mappedBy = "unit", cascade = CascadeType.ALL)
    private GPSDevice gpsDevice;
}