package pl.logistic.unifiedlogistixsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.logistic.unifiedlogistixsystem.model.Mission;

import java.time.LocalDateTime;

public interface MissionRepository extends JpaRepository<Mission, Long> {

    // Sprawdza, czy istnieje misja nakładająca się czasowo na podany przedział
    @Query("SELECT CASE WHEN COUNT(m) > 0 THEN true ELSE false END FROM Mission m " +
            "WHERE m.startDate < :end AND m.endDate > :start")
    boolean existsByTimeOverlap(@Param("start") LocalDateTime start, @Param("end") LocalDateTime end);

    // Jak wyżej, ale ignoruje misję o excludeId (przy aktualizacji)
    @Query("SELECT CASE WHEN COUNT(m) > 0 THEN true ELSE false END FROM Mission m " +
            "WHERE m.startDate < :end AND m.endDate > :start AND m.id <> :excludeId")
    boolean existsByTimeOverlapExcludingId(@Param("start") LocalDateTime start,
                                           @Param("end") LocalDateTime end,
                                           @Param("excludeId") Long excludeId);
}
