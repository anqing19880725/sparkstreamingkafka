package source;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.spark.streaming.kafka010.ConsumerStrategies;
import org.apache.spark.streaming.kafka010.KafkaUtils;
import org.apache.spark.streaming.kafka010.LocationStrategies;

import java.util.*;

public class sourceKafka {

    public static void main(String[] args) {

        SparkConf sparkConf = new SparkConf().setAppName("sparkStreamingKafka").setMaster("local[*]");

//        SparkConf sparkConf = new SparkConf().setAppName("sparkStreamingKafka").setMaster("spark://master:7077")
//                .set("spark.executor.memory", "2g")
//                .set("spark.dynamicAllocation.enabled", "false");

//        JavaSparkContext jsc = new JavaSparkContext(sparkConf);

        //
        JavaStreamingContext javaStreamingContext = new JavaStreamingContext(sparkConf,Durations.seconds(10));

//        javaStreamingContext.socketTextStream("localhost",6666);

        String brokers = "10.182.143.146:21005,10.182.143.147:21005,10.182.143.148:21005";//指定kafka地址
        String groupId = "GroupMin";//指定消费者组id
        String topics = "DMGR_PUB_SYS0240";//指定topic

        // 用集合存kafka的参数
        Set<String> topicsSet = new HashSet<>(Arrays.asList(topics.split(",")));
        Map<String, Object> kafkaParams = new HashMap<String, Object>();
        kafkaParams.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, brokers);
        kafkaParams.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        kafkaParams.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        kafkaParams.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        kafkaParams.put("auto.offset.reset", "latest");
        kafkaParams.put("enable.auto.commit", false);

        JavaInputDStream<ConsumerRecord<String, String>> messages  = KafkaUtils.createDirectStream(javaStreamingContext, LocationStrategies.PreferConsistent(), ConsumerStrategies.Subscribe(topicsSet, kafkaParams));
		
		messages.print();
		
		
		javaStreamingContext.start();
        javaStreamingContext.awaitTermination();
        javaStreamingContext.close();
		


    }


}
