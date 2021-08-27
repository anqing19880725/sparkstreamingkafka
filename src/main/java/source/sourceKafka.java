package source;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.api.java.function.VoidFunction;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaInputDStream;
import org.apache.spark.streaming.api.java.JavaPairDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.spark.streaming.kafka010.ConsumerStrategies;
import org.apache.spark.streaming.kafka010.KafkaUtils;
import org.apache.spark.streaming.kafka010.LocationStrategies;
import pojo.AfterColumnList;
import pojo.JsonRootBean;

import java.util.*;

public class sourceKafka {

    public static void main(String[] args) throws Exception {

        SparkConf sparkConf = new SparkConf().setAppName("sparkStreamingKafka").setMaster("local[*]");

//        SparkConf sparkConf = new SparkConf().setAppName("sparkStreamingKafka").setMaster("spark://master:7077")
//                .set("spark.executor.memory", "2g")
//                .set("spark.dynamicAllocation.enabled", "false");

//        JavaSparkContext jsc = new JavaSparkContext(sparkConf);

        //
        JavaStreamingContext javaStreamingContext = new JavaStreamingContext(sparkConf, Durations.seconds(10));

//        javaStreamingContext.socketTextStream("localhost",6666);

        String brokers = "10.182.143.146:21005";//指定kafka地址
        String groupId = "GroupMin";//指定消费者组id
        String topics = "DMGR_PUB_SYS0240";//指定topic

        // 用集合存kafka的参数
        Set<String> topicsSet = new HashSet<>(Arrays.asList(topics.split(",")));
        Map<String, Object> kafkaParams = new HashMap<String, Object>();
        kafkaParams.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, brokers);
        kafkaParams.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        kafkaParams.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        kafkaParams.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        kafkaParams.put("auto.offset.reset", "earliest");  //earliest latest
        kafkaParams.put("enable.auto.commit", false);


        JavaInputDStream<ConsumerRecord<String, String>> messages = KafkaUtils.createDirectStream(javaStreamingContext, LocationStrategies.PreferConsistent(), ConsumerStrategies.Subscribe(topicsSet, kafkaParams));

        JavaDStream<String> map = messages.map(new Function<ConsumerRecord<String, String>, String>() {

//            Gson gson = new Gson();
            @Override
            public String call(ConsumerRecord<String, String> ConsumerRecord) throws Exception {
                return new Gson().fromJson(ConsumerRecord.value(), JsonRootBean.class).toString();
            }
        });

        map.foreachRDD(new VoidFunction<JavaRDD<String>>() {
            @Override
            public void call(JavaRDD<String> stringJavaRDD) throws Exception {
                System.out.println(stringJavaRDD);
                stringJavaRDD.foreach(new VoidFunction<String>() {
                    @Override
                    public void call(String s) throws Exception {
                        System.out.println(s);
                    }
                });
            }
        });


        //        Gson gson = new Gson();
//        JsonRootBean jsonRootBean = gson.fromJson(map.toString(),JsonRootBean.class);
//        System.out.println(jsonRootBean);
//        String tableName = jsonRootBean.getTableName();
//        System.out.println(tableName);
//        List<AfterColumnList> afterColumnList = jsonRootBean.getAfterColumnList();

        javaStreamingContext.start();
        javaStreamingContext.awaitTermination();
        javaStreamingContext.close();

    }
}
