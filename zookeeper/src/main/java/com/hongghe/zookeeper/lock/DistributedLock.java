package com.hongghe.zookeeper.lock;

import java.util.concurrent.TimeUnit;

/**
 * @author: hongghe @date: 2019-04-02 16:48
 */
public interface DistributedLock {

    public boolean tryLock() throws Exception;

    public void lock() throws Exception;

    public boolean lock(long time, TimeUnit timeUnit) throws Exception;

    public void unLock() throws Exception;
}
