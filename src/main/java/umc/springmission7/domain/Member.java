package umc.springmission7.domain;

import lombok.*;
import umc.springmission7.domain.common.BaseEntity;
import umc.springmission7.domain.enums.FoodType;
import umc.springmission7.domain.enums.Gender;
import umc.springmission7.domain.enums.MemberStatus;
import umc.springmission7.domain.enums.SocialType;
import umc.springmission7.domain.mapping.MemberMission;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10)")
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    private LocalDate birth;

    @Column(nullable = false, length = 40)
    private String address;

    @Enumerated(EnumType.STRING)
    private FoodType foodType;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(15) DEFAULT 'ACTIVE'")
    private MemberStatus status;

    private LocalDate inactiveDate;

    private String userId;

    private String pw;

    private String phoneNumber;

    @Column(nullable = false, length = 50)
    private String email;

    private int point;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Review> memberMissionList = new ArrayList<>();

}
