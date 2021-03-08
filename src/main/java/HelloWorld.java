import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonFormat;

public class HelloWorld {

    private String hello;

    public HelloWorld() {
    }

    public HelloWorld(final String hello) {
        this.hello = hello;
    }

    public String getHello() {
        return this.hello;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Hello{");
        sb.append("hello=").append(hello);
        sb.append("}");
        return sb.toString();
    }
}