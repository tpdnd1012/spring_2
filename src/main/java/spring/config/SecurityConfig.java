package spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
                                    // 웹 보안 설정 연결 클래스

    @Override // 웹서버 보안
    public void configure(WebSecurity web) throws Exception {

    }

    @Override // 웹 HTTP 보안
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests() // 클라이언트가 Http 요청 값에 해당하는 보안 설정
                .antMatchers("/admin/**").hasAnyRole("ADMIN") // 특정 URL 이후의 Role 접속 권한 부여
                .antMatchers("/user/myinfo").hasRole("MEMBER") // 특정페이지에 Role 접속 권한 부여
                .antMatchers("/**").permitAll(); // / 이후 모든 URL 접근 가능

    }
}
