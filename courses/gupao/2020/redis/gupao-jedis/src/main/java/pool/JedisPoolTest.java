package pool;

import redis.clients.jedis.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JedisPoolTest {

    public static void main(String[] args) {
        ordinaryPool();
        shardedPool();
        sentinelPool();
    }

    /**
     * 普通连接池
     */
    public static void ordinaryPool(){
        JedisPool pool = new JedisPool("192.168.44.181",6379);
        Jedis jedis = pool.getResource();
        jedis.set("qingshan","平平无奇盆鱼宴");
        System.out.println(jedis.get("qingshan"));
    }

    /**
     * 分片连接池
     */
    public static void shardedPool() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();

        // Redis服务器
        JedisShardInfo shardInfo1 = new JedisShardInfo("192.168.44.181", 6379);

        // 连接池
        List<JedisShardInfo> infoList = Arrays.asList(shardInfo1);
        ShardedJedisPool jedisPool = new ShardedJedisPool(poolConfig, infoList);

        ShardedJedis jedis = jedisPool.getResource();
        jedis.set("qingshan","分片测试");
        System.out.println(jedis.get("qingshan"));
    }

    /**
     * 哨兵连接池
     */
    public static void sentinelPool() {
        String masterName = "redis-master";
        Set<String> sentinels = new HashSet<String>();
        sentinels.add("192.168.44.186:26379");
        sentinels.add("192.168.44.187:26379");
        sentinels.add("192.168.44.188:26379");

        JedisSentinelPool pool = new JedisSentinelPool(masterName, sentinels);
        pool.getResource().set("qingshan", "哨兵" + System.currentTimeMillis() + "盆鱼宴");
        System.out.println(pool.getResource().get("qingshan"));
    }



}
