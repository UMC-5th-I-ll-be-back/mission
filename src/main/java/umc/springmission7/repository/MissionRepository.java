package umc.springmission7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.springmission7.domain.Mission;

import java.util.Optional;

public interface MissionRepository extends JpaRepository<Mission, Long> {
     Optional<Mission> findById(Long id);
}
