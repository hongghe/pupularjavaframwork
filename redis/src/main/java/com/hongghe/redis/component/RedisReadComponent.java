package com.hongghe.redis.component;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author: hongghe @date: 2019-03-21 16:41
 */
@Component
public class RedisReadComponent {

    private ExecutorService executorService;

    @PostConstruct
    private void ini() {
        this.executorService = new ThreadPoolExecutor(10,
                20,
                30,
                TimeUnit.SECONDS,
                new SynchronousQueue<>(),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );
    }

    public void getMethod() {
        this.executorService.execute(() -> runMethod());
    }

    public boolean runMethod() {
        return true;
    }

    @PreDestroy
    private void destroy() throws InterruptedException {
       executorService.shutdown();
       executorService.awaitTermination(30, TimeUnit.SECONDS);
    }
}
