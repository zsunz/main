package com.example.demo2;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // Jpa 데이터베이스 업데이트가 발생했을시 -> 즉시 반영
@SpringBootTest
class Demo2ApplicationTests {

    @Test
    void contextLoads() {
    }

}
