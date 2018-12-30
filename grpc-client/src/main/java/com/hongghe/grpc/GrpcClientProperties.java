package com.hongghe.grpc;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author hongghe 2018/12/25
 */
@Data
@ConfigurationProperties("grpcclientdemo")
public class GrpcClientProperties {
}
