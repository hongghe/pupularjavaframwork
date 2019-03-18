package com.hongghe.zookeeper.component;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author: hongghe @date: 2019-03-18 20:16
 */
public class TestLeaderSelection {


    private static ZooKeeper zooKeeper;

    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException, KeeperException {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        List<Future<String>> futureList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            Callable<String> callable = new LeaderElection(zooKeeper, "/path", "election-" + i);
            Future<String> future = threadPool.submit(callable);
            futureList.add(future);
        }
        for (Future<String> future : futureList) {
            String leaderNode = future.get();
            if (!leaderNode.isEmpty()) {
                System.out.println("leader node is " + leaderNode);
            }
        }
    }
}
