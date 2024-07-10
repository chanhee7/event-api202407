package com.study.event.api.event.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@ToString
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "tbl_email_verification")
public class EmailVerification {

    @Id
    @GenericGenerator(strategy = "uuid2", name = "uuid-generator")
    @GeneratedValue(generator = "uuid-generator")
    @Column(name = "verification_id")
    private String id; // 회원 계정이 아니고 랜덤문자 PK

    @Column(nullable = false)
    private String verificationCode; // 인증 코드

    @Column(nullable = false)
    private LocalDateTime expiryDate; // 인증 만료시간

    @OneToOne
    @JoinColumn(name = "ev_user_id", referencedColumnName = "ev_user_id")
    private EventUser eventUser;

    // 두개의 테이블에 FK 가 다른 테이블의 PK랑 이름이 다른경우
    /*
        ALTER TABLE tbl_email_verification
        ADD CONSTRAINT fk_@@@@_@@@@@
        FOREIGN KEY (event_user_id) -> name = "ev_user_id" 매칭
        REFERENCES tbl_event_user (ev_user_id) -> referencedColumnName = "ev_user_id" 매칭
     */
}
