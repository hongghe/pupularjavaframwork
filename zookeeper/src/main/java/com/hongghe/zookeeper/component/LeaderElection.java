package com.hongghe.zookeeper.component;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

import java.util.List;
import java.util.concurrent.Callable;

/**
 * @author: hongghe @date: 2019-03-18 20:14
 */
public class LeaderElection implements Callable<String> {

    private ZooKeeper zooKeeper;
    private String znodePath;
    private String name;

    private String newNodeName = null;
    private static boolean isLeader = false;

    LeaderElection(ZooKeeper zooKeeper, String znodePath, String name) {
        this.zooKeeper = zooKeeper;
        this.znodePath = znodePath;
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        String fullPath = znodePath + "/queue-";
        newNodeName = zooKeeper.create(fullPath, this.name.getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.EPHEMERAL_SEQUENTIAL);
        System.out.println(this.name + " created node:" + newNodeName);
        List<String> nodeList = zooKeeper.getChildren(this.znodePath, false);
        isLeader = checkIsLeader(nodeList, newNodeName);
        System.out.println(this.name + " is leader:" + isLeader);
        if (!isLeader) {
            zooKeeper.delete(newNodeName, zooKeeper.exists(newNodeName, false).getVersion());
            return "";
        } else {
            return newNodeName;
        }
    }

    private boolean checkIsLeader(List<String> nodeList, String newNodeName) {
        int curValue = getNumber(newNodeName);
        for (String node : nodeList) {
            if (getNumber(node) < curValue) {
                return false;
            }
        }
        return true;
    }

    private int getNumber(String queueNode) {
        queueNode = queueNode.substring(queueNode.length() - 10, queueNode.length());
        return Integer.parseInt(queueNode);
    }


}
