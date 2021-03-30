package datatype;

import util.JedisUtil;

/**
 * qingshan
 */
public class SimpleTest {
    public static void main(String[] args) {

        JedisUtil.getJedisUtil().set("qingshan","2673");
        //JedisUtil.getJedisUtil().get("qingshan");

    }
}
