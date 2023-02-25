package com.cqry.order_pipeline;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
// @RunWith(SpringJUnit4ClassRunner.class)
////这是Spring Boot注解，为了进行集成测试，需要通过这个注解加载和配置Spring应用上下
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,classes = ApiApplication.class)
class OrderPipelineApplicationTests {

	@Test
	void contextLoads() {
		System.out.println("1234");
	}

}
