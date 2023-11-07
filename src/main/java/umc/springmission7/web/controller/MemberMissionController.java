package umc.springmission7.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import umc.springmission7.apiPayload.ApiResponse;
import umc.springmission7.domain.Mission;
import umc.springmission7.domain.mapping.MemberMission;
import umc.springmission7.web.dto.MemberMissionResponse;
import umc.springmission7.web.dto.TempResponse;
import umc.springmission7.service.MemberMissionService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberMissionController {
    private final MemberMissionService memberMissionService;

    @GetMapping("/missions")
    public ResponseEntity<List<MemberMission>> getMissions(@RequestParam("status") String status) {
        List<MemberMission> memberMissions;
        memberMissions = memberMissionService.getMissionsByStatus(status);
        return ResponseEntity.ok(memberMissions);
    }
}
