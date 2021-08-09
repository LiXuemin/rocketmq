package org.apache.rocketmq.client.lxmproducer;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class MyMQProducerTest {

    private DefaultMQProducer producer;

    @Test
    public void init()  {
        try {


        String producerGroupTemp = "lxm-producer-group";
        producer = new DefaultMQProducer(producerGroupTemp);
        producer.setNamesrvAddr("127.0.0.1:9876");
        producer.start();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            producer.shutdown();
        }
    }
}