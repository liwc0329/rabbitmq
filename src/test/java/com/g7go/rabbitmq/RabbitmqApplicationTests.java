package com.g7go.rabbitmq;

import com.g7go.rabbitmq.send.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqApplicationTests {

    @Autowired
    private Sender sender;

    /**
     * DirectReceiver1  : hello
     *
     * @throws Exception
     */
    @Test
    public void hello() throws Exception {
        sender.send();
    }

    /**
     * TopicReceiver2  : hello
     * TopicReceiver1  : hello
     * TopicReceiver2  : hello
     *
     * @throws Exception
     */
    @Test
    public void topic() throws Exception {
        sender.send2();
        sender.send3();
    }

    /**
     * FanoutReceiver3  : hello
     * FanoutReceiver2  : hello
     * FanoutReceiver1  : hello
     *
     * @throws Exception
     */
    @Test
    public void fanout() throws Exception {
        sender.send4();
    }

    /**
     * HeaderReceiver1  : hello
     *
     * @throws Exception
     */
    @Test
    public void header() throws Exception {
        sender.send5();
    }

}

