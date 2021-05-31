package spring.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // MVC 모델 중 Controller 관련 프로그램 제공
public class IndexController {

    @GetMapping("/")
    public String index() {

        return "index"; // 일반적으로 index 문자열 반환하는 메소드
        // 타임리프 사용시 : index 라는 html 파일을 찾아서 반환

    }

}
