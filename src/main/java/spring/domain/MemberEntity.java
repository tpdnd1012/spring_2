package spring.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity // 현재 클래스를 DB 테이블 맵핑
@Getter
@NoArgsConstructor // 기본 생성자
public class MemberEntity {

    // oauth2 : sns 회원 끌어오기

    @Id // 기본키
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 해당갑이 null 이면 => 자동번호 부여
    Long id; // 회원번호

    @Column // 필드
    String name; // 회원명

    @Column // 필드
    String email; // 사용자 이메일

    @Enumerated(EnumType.STRING) // 열거형 String 타입으로 넣기 => 생략시 : 번호로 들어감
    @Column
    Role role;

    // 생성자
    @Builder
    public MemberEntity(Long id, String name, String email, Role role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
    }
    
    // Role 키 반환 메소드
    public String getRolekey() {

        return this.role.getKey();

    }
    
}
