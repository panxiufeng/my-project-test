package com.pxf.project.demo2;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class KafkaProducerOps {

    public static void main(String[] args) throws IOException {
        /**
         * 专门加载配置文件
         * 配置文件的格式：
         * key=value
         *
         * 在代码中要尽量减少硬编码
         *  不要将代码写死，要可配置化
         */
        Properties properties = new Properties();
        InputStream in = KafkaProducerOps.class.getClassLoader().getResourceAsStream("producer.properties");
        properties.load(in);
        /**
         * 两个泛型参数
         * 第一个泛型参数：指的就是kafka中一条记录key的类型
         * 第二个泛型参数：指的就是kafka中一条记录value的类型
         */
        String[] girls = new String[]{"姚慧莹", "刘向前", "周  新", "杨柳"};
        Producer<String, String> producer = new KafkaProducer<String, String>(properties);
        String topic = properties.getProperty(Constants.KAFKA_PRODUCER_TOPIC);
        String key = "1";
        String value = "今天的姑娘们很美";
        ProducerRecord<String, String> producerRecord =
                new ProducerRecord<String, String>(topic, key, value);
        producer.send(producerRecord);
        producer.close();
    }
}
