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
    private MissionRepository missionRepository;

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
        Optional<Mission> mission = missionRepository.findById(missionId);
        Integer newReward = missionRequestDto.getReward();
        String newContent = missionRequestDto.getContent();
        LocalDate newDeadLine = missionRequestDto.getDeadline();


        mission.get().updateMissionDetail(newReward, newContent, newDeadLine);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public void deleteMission(Long missionId){
        Mission mission = getMissionById(missionId);
        missionRepository.delete(mission);
    }



}
