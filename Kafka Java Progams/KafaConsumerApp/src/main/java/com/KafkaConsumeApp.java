package com;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

public class KafkaConsumeApp {

	public static void main(String[] args) {
	String topicName = "sample";
	Properties props = new Properties();
	props.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
	props.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
	props.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
	props.setProperty(ConsumerConfig.GROUP_ID_CONFIG, "g1");
	Consumer<String, String> consumer = new KafkaConsumer<>(props);
	List<String> ll = Arrays.asList(topicName);
	//consumer.subscribe(Arrays.asList(topicName));
	consumer.subscribe(ll);
	System.out.println("Topic details for subscribe "+topicName);
							//consumer.poll(1000);
		ConsumerRecords<String, String> crs = consumer.poll(Duration.ofMinutes(2));
		for(ConsumerRecord<String, String> cr:crs) {
			System.out.println("Key "+cr.key()+" value "+cr.value());
		}
		consumer.close();
	}
	
}
