import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.connectors.kinesis.FlinkKinesisConsumer;
import org.apache.flink.streaming.connectors.kinesis.config.AWSConfigConstants;
import org.apache.flink.streaming.connectors.kinesis.config.ConsumerConfigConstants;
import io.github.cdimascio.dotenv.Dotenv;

import java.util.Properties;

public class main {
    static final String AWS_REGION = "AWS_REGION";
    static final String AWS_ACCESS_KEY_ID = "AWS_ACCESS_KEY_ID";
    static final String AWS_SECRET_ACCESS_KEY = "AWS_SECRET_ACCESS_KEY";
    static final String STREAM_INITIAL_POSITION = "LATEST";
    static final String KINESIS_STREAM_NAME = "KINESIS_STREAM_NAME";

    public static void main(String[] args) {

        Dotenv dotEnv = Dotenv.load();
        Properties consumerConfig = new Properties();
        consumerConfig.put(AWSConfigConstants.AWS_REGION, dotEnv.get(AWS_REGION));
        consumerConfig.put(AWSConfigConstants.AWS_SECRET_ACCESS_KEY, dotEnv.get(AWS_SECRET_ACCESS_KEY));
        consumerConfig.put(AWSConfigConstants.AWS_ACCESS_KEY_ID, dotEnv.get(AWS_ACCESS_KEY_ID));
        consumerConfig.put(ConsumerConfigConstants.STREAM_INITIAL_POSITION, STREAM_INITIAL_POSITION);

        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStream<HelloWorld> kinesis = env.addSource(new FlinkKinesisConsumer<>(dotEnv.get(KINESIS_STREAM_NAME), new HelloWorldDeserializationSchema(), consumerConfig));
        kinesis.print();

        try {
            env.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
