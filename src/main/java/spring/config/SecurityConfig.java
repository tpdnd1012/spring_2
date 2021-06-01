package spring.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import spring.service.Oauth2Service;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
                                    // 웹 보안 설정 연결 클래스

    private final Oauth2Service oauth2Service;

    @Override // 웹서버 보안
    public void configure(WebSecurity web) throws Exception {

    }

    @Override // 웹 HTTP 보안
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests() // 클라이언트가 Http 요청 값에 해당하는 보안 설정
                .antMatchers("/admin/**").hasAnyRole("ADMIN") // 특정 URL 이후의 Role 접속 권한 부여
                .antMatchers("/user/myinfo").hasRole("MEMBER") // 특정페이지에 Role 접속 권한 부여
                .antMatchers("/**").permitAll() // / 이후 모든 URL 접근 가능

               .and() // 연결 메소드
                .csrf() // 사이트 간 요청 위조
                .ignoringAntMatchers("/h2-console/**") // 사이트 간 요청 위조 방지를 제거해서 console 사용

               .and()
                .oauth2Login() // Oauth2 로그인 설정
                .userInfoEndpoint()
                .userService(oauth2Service);
        
        http.headers().frameOptions().disable(); // h2 접근 하기 위해 frame 제거

    }

}
