import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.api.common.serialization.DeserializationSchema;

import java.io.IOException;
import java.util.Base64;

public class HelloWorldDeserializationSchema implements DeserializationSchema<HelloWorld> {
    private final static ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public HelloWorld deserialize(byte[] message) throws IOException {
        return objectMapper.readValue(message, HelloWorld.class);
    }

    @Override
    public boolean isEndOfStream(HelloWorld nextElement) {
        return false;
    }

    @Override
    public TypeInformation<HelloWorld> getProducedType() {
        return TypeInformation.of(HelloWorld.class);
    }
}
