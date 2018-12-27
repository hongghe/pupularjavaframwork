package com.hongghe.grpcserver;

import io.grpc.BindableService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * @author hongghe 2018/12/27
 */
@Component("grpcLauncher")
@Slf4j
public class GrpcLauncher {

    /**
     * 定义Grpc Server
     */
    private Server server;


    @Value("${grpc.server.port}")
    private Integer grpcServerPort;
    /**
     * GRPC 服务启动方法
     * @param grpcServiceBeanMap
     */
    public void grpcStart(Map<String, Object> grpcServiceBeanMap) {
        try{
            ServerBuilder serverBuilder = ServerBuilder.forPort(grpcServerPort);
            for (Object bean : grpcServiceBeanMap.values()){
                serverBuilder.addService((BindableService) bean);
                log.info(bean.getClass().getSimpleName() + " is regist in Spring Boot");
            }
            server = serverBuilder.build().start();
            log.info("grpc server is started at " +  grpcServerPort);
            server.awaitTermination();
            Runtime.getRuntime().addShutdownHook(new Thread(()->{grpcStop();}));
        } catch (IOException e){
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * GRPC 服务Stop方法
     */
    private void grpcStop(){
        if (server != null){
            server.shutdownNow();
        }
    }
}