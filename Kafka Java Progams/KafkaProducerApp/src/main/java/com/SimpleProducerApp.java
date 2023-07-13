package com;

import java.util.Date;
import java.util.Properties;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

class MyCallBack implements Callback{
	@Override
	public void onCompletion(RecordMetadata metadata, Exception exception) {
		if(exception==null) {
			System.out.println("Topic "+metadata.topic());
			System.out.println("partition "+metadata.partition());
			System.out.println("offset "+metadata.offset());
			System.out.println("time "+new Date(metadata.timestamp()));
		}
	}
}
public class SimpleProducerApp {
	public static void main(String[] args) {
	String topicName = "sample";
	Properties props = new Properties();
	props.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
	props.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
	props.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
	
	Producer<String, String> producer = new KafkaProducer<String,String>(props);
	
	for(int i=0;i<=10;i++) {
		//1st parameter topic name, 2nd parameter key, 3rd paramter value
ProducerRecord<String,String> data = 
new ProducerRecord<String, String>(topicName,"key "+i, "Simple message produce through Java in Kafa for Sample1"+(i+0)+" messge");		
//producer.send(data);
producer.send(data, new MyCallBack());

	}
	producer.close();
	System.out.println("Message send successfully.....");
	}

}
