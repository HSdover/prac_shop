package com.shop.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
// Web(spring MVC)에 집중할 수 있는 어노테이션
// @Service, @Component, @Repository에는 사용 x
// 컨트롤러만 사용하기 때문에 선언한다!
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

    // 스프링이 관리(IoC)하는 빈(Bean)을 주입 받는다. (DI)
    @Autowired
    // 웹 API를 테스트할때 사용
    // 스프링 MVC 테스트의 시작점
    // 이 클래스를 통해 HTTP GET, POST등에 대한 API테스트를 할 수 있다.
    private MockMvc mvc;

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        // MockMvc를 통해 /hello 주소로 HTTP GET 요청을 한다.
        // 체이닝이 지원되어 여러 검증 기능을 이어서 선언할 수 있다.
        mvc.perform(get("/hello"))
                .andExpect(status().isOk()) // Header의 Status를 검증한다.(200, 500, 404등)
                .andExpect(content().string(hello));    // 응답 본문의 내용을 검증한다. (Controller에서 "hello"를 리턴하기에 똑같은지 확인
    }
}
