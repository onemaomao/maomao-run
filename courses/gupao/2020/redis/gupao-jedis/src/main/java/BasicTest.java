package datatype;

import redis.clients.jedis.Jedis;

/**
 * qingshan
 */
public class BasicTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.44.181", 6379);
        jedis.set("qingshan", "2673jedis");
        System.out.println(jedis.get("qingshan"));
        jedis.close();
    }
}
