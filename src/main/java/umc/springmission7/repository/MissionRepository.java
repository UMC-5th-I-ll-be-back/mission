package umc.springmission7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.springmission7.domain.Mission;

public interface MissionRepository extends JpaRepository<Mission, Long> {
}
