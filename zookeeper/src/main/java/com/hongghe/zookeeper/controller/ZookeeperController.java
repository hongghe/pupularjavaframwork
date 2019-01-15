package com.hongghe.zookeeper.controller;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: hongghe @date: 2019-01-12 14:52
 */
@Slf4j
@RestController
@RequestMapping(path = "/zookeeper")
public class ZookeeperController {

    @RequestMapping(value = "get")
    public String getZookeeper() {
       Watcher watcher = new Watcher() {
            public void process(WatchedEvent event) {
                log.info("[getZookeeper]Event = {}", new Gson().toJson(event));
            }
        };

      new Watcher() {
          @Override
          public void process(WatchedEvent event) {
              log.info("[getZookeeper]Event = {}", new Gson().toJson(event));
          }
      };

        String value = null;
        try {
            final ZooKeeper zookeeper = new ZooKeeper("127.0.0.1:2181", 1000000, watcher);
            final byte[] data = zookeeper.getData("/node_1", watcher, null);
            value = new String(data);
            zookeeper.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return "draw the value from zookeeper [" + value + "]";
    }
}
