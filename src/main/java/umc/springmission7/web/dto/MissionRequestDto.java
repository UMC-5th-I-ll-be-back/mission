package umc.springmission7.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@RequiredArgsConstructor
public class MissionRequestDto {
    private Integer reward;
    private String content;
    private LocalDate deadline;
}
