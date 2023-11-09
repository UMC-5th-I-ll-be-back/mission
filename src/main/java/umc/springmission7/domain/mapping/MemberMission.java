package umc.springmission7.domain.mapping;

import lombok.*;
import umc.springmission7.domain.Member;
import umc.springmission7.domain.Mission;
import umc.springmission7.domain.common.BaseEntity;
import umc.springmission7.domain.enums.MemberMissionStatus;
import umc.springmission7.domain.enums.MissionStatus;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberMission extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private MemberMissionStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="mission_id")
    private Mission mission;
}
