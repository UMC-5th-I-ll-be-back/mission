package umc.springmission7.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.springmission7.domain.Mission;
import umc.springmission7.service.MissionService;
import umc.springmission7.web.dto.MissionRequestDto;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/mission")
public class MissionController {
    private final MissionService missionService;

    @PostMapping
    public ResponseEntity<Mission> addMission(@RequestBody MissionRequestDto missionRequestDto){
        Mission savedMission = missionService.addMission(missionRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedMission);
    }

    @GetMapping
    public List<Mission> getMissionList(){
        return missionService.getMissionList();
    }

    @GetMapping("/{mission_id}")
    public Mission getMission(@PathVariable Long mission_id){
        return missionService.getMissionById(mission_id);
    }

    @PutMapping ("/{mission_id}")
    public ResponseEntity<Void> updateMission (@PathVariable("mission_id") Long mission_id,@RequestBody MissionRequestDto missionRequestDto) {
        missionService.updateMission(mission_id, missionRequestDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @DeleteMapping("/{mission_id}")
    public ResponseEntity<Void> deleteMission(@PathVariable("mission_id") Long mission_id) {
        missionService.deleteMission(mission_id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
