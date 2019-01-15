package com.hongghe.apollo;

import com.ctrip.framework.apollo.core.ConfigConsts;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import com.google.common.base.Strings;
import io.prometheus.client.hotspot.DefaultExports;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@Slf4j
@EnableAsync
@EnableScheduling
@SpringBootApplication
@EnableApolloConfig({ConfigConsts.NAMESPACE_APPLICATION, "apollo.test_config"})
public class ApolloApplication {

	static {
		// 如果本地启动时，需要自动配置
		if (Strings.isNullOrEmpty(System.getProperty("spring.profiles.active"))
				&& Strings.isNullOrEmpty(System.getenv("SPRING_PROFILES_ACTIVE"))) {
			System.setProperty("env", "DEV");
			System.setProperty("app.id", "apollo.test_config");
		}
		DefaultExports.initialize();
	}

	@Bean
	public ApolloProperties apolloProperties() {
		return new ApolloProperties();
	}

	@Bean
	public ApolloInitializer apolloInitializer() {
		return new ApolloInitializer();
	}

	public static void main(String[] args) {
		SpringApplication.run(ApolloApplication.class, args);
	}

}

