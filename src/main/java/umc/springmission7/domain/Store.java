package umc.springmission7.domain;

import lombok.*;
import umc.springmission7.domain.common.BaseEntity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Store extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 40)
    private String address;

    @Column(nullable = false)
    private Float score;

    @Column(nullable = false)
    private String name;

}
