package pubsub;

import redis.clients.jedis.Jedis;

/**
 * qingshan
 */
public class PublishTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.44.181", 6379);
        jedis.publish("qingshan-channel", "2673");
        jedis.publish("penyuyan-channel", "盆鱼宴");
    }
}
