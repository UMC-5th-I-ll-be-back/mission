package umc.springmission7.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import umc.springmission7.domain.Mission;
import umc.springmission7.repository.MissionRepository;
import umc.springmission7.web.dto.MissionRequestDto;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MissionService {
    // TODO: 2023/11/05 MemberMissionService 주입

    private final MissionRepository missionRepository;

    public Mission addMission(MissionRequestDto requestDto){
        Integer reward = requestDto.getReward();
        String content = requestDto.getContent();
        LocalDate deadline = requestDto.getDeadline();
        return missionRepository.save(Mission.builder()
                .reward(reward)
                .content(content)
                .deadline(deadline)
                .build());
    }

    public List<Mission> getMissionList(){
        return missionRepository.findAll();
    }

    public Mission getMissionById(Long missionId){
        return missionRepository.findById(missionId).orElseThrow();
    }

    public ResponseEntity<Void> updateMission(Long missionId, MissionRequestDto missionRequestDto){
        Mission mission = getMissionById(missionId);

        Integer newReward = missionRequestDto.getReward();
        String newContent = missionRequestDto.getContent();
        LocalDate newDeadLine = missionRequestDto.getDeadline();

        // 값이 들어오지 않았을 경우 기존 값으로 유지
        if (newReward == null) {
            newReward = mission.getReward();
        }
        if (newContent == null) {
            newContent = mission.getContent();
        }
        if (newDeadLine == null) {
            newDeadLine = mission.getDeadline();
        }

        mission.updateMissionDetail(newReward, newContent, newDeadLine);
        missionRepository.save(mission);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public void deleteMission(Long missionId){
        Mission mission = getMissionById(missionId);
        missionRepository.delete(mission);
    }


}
