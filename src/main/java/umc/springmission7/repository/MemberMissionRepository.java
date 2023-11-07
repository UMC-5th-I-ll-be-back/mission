package umc.springmission7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.springmission7.domain.enums.MissionStatus;
import umc.springmission7.domain.mapping.MemberMission;

import java.util.List;

@Repository
public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
    List<MemberMission> findByStatus(MissionStatus status);
}

