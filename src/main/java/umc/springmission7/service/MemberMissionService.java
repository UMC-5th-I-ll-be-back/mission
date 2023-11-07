package umc.springmission7.service;

import org.springframework.stereotype.Service;
import umc.springmission7.domain.enums.MissionStatus;
import umc.springmission7.domain.mapping.MemberMission;
import umc.springmission7.repository.MemberMissionRepository;

import java.util.List;

@Service
public class MemberMissionService {
    private final MemberMissionRepository memberMissionRepository;

    public MemberMissionService(MemberMissionRepository memberMissionRepository) {
        this.memberMissionRepository = memberMissionRepository;
    }

    public List<MemberMission> getMissionsByStatus(String status) {
        MissionStatus missionStatus = MissionStatus.valueOf(status);
        return memberMissionRepository.findByStatus(missionStatus);
    }

}

