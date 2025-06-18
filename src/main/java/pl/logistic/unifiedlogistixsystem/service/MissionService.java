package pl.logistic.unifiedlogistixsystem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.logistic.unifiedlogistixsystem.dto.MissionDto;
import pl.logistic.unifiedlogistixsystem.mapper.MissionMapper;
import pl.logistic.unifiedlogistixsystem.model.Mission;
import pl.logistic.unifiedlogistixsystem.repository.MissionRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MissionService {

    private final MissionRepository missionRepository;
    private final MissionMapper missionMapper;

    public List<MissionDto> getAllMissions() {
        return missionRepository.findAll()
                .stream()
                .map(missionMapper::toDto)
                .collect(Collectors.toList());
    }

    public Optional<MissionDto> getMissionById(Long id) {
        return missionRepository.findById(id)
                .map(missionMapper::toDto);
    }

    public MissionDto createMission(MissionDto missionDto) {
        if (missionDto.getId() != null) {
            throw new IllegalArgumentException("Nowa misja nie może mieć ustawionego ID");
        }
        Mission mission = missionMapper.toEntity(missionDto);
        Mission saved = missionRepository.save(mission);
        return missionMapper.toDto(saved);
    }

    public Optional<MissionDto> updateMission(Long id, MissionDto missionDto) {
        return missionRepository.findById(id)
                .map(existing -> {
                    existing.setName(missionDto.getName());
                    existing.setDescription(missionDto.getDescription());
                    existing.setStartDate(missionDto.getStartDate());
                    existing.setEndDate(missionDto.getEndDate());
                    existing.setStatus(missionDto.getStatus());
                    if (missionDto.getUnitId() != null) {
                        existing.setUnit(missionMapper.unitFromId(missionDto.getUnitId()));
                    }
                    Mission updated = missionRepository.save(existing);
                    return missionMapper.toDto(updated);
                });
    }

    public void deleteMission(Long id) {
        missionRepository.deleteById(id);
    }
}
