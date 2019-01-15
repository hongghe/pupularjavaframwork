package com.hongghe.apollo;

import com.google.common.base.Strings;
import io.prometheus.client.hotspot.DefaultExports;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApolloApplicationTests {

	static {
		// 如果本地启动时，需要自动配置
		if (Strings.isNullOrEmpty(System.getProperty("spring.profiles.active"))
				&& Strings.isNullOrEmpty(System.getenv("SPRING_PROFILES_ACTIVE"))) {
			System.setProperty("env", "DEV");
			System.setProperty("app.id", "apollo.test_config");
		}
		DefaultExports.initialize();
	}

	@Test
	public void contextLoads() {
	}

}

