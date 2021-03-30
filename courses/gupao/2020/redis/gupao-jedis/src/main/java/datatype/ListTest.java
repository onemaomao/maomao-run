package datatype;

import util.JedisUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * qingshan
 */
public class ListTest {
    public static void main(String[] args) {

        JedisUtil.getJedisUtil().lpush("msgList","qingshan发送了条消息");
        JedisUtil.getJedisUtil().lpush("msgList","lisa发送了个动态");
        JedisUtil.getJedisUtil().lpush("msgList","lily发送了个动态");
        //左边进左边出（先进后出）
        for (int i = 0; i < 3; i++) {
            System.out.println(JedisUtil.getJedisUtil().lpop("msgList"));
        }
    }
}
