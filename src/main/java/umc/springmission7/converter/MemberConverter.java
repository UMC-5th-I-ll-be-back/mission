package umc.springmission7.converter;

import umc.springmission7.web.dto.TempResponse;

public class MemberConverter {
    public static TempResponse.TempTestDTO toTempTestDTO(){
        return TempResponse.TempTestDTO.builder()
                .testString("미션진행중입니다.")
                .build();
    }
}
