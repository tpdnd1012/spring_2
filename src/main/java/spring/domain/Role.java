package spring.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    
    // 열거형
    USER("ROLE_USER", "회원"),
    ADMIN("ROLE_ADMIN", "관리자");

    private final String key;
    private final String title;
    
}
