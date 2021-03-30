package datatype;

import util.JedisUtil;

import java.util.Set;

/**
 * qingshan
 */
public class ZSetTest {
    public static void main(String[] args) {

        //region 绩效排行
        // 现在青山公司要做绩效考核 ，默认都是50分
        JedisUtil.getJedisUtil().zadd("qingshanCompany", 50, "lily");
        JedisUtil.getJedisUtil().zadd("qingshanCompany", 50, "lucy");
        JedisUtil.getJedisUtil().zadd("qingshanCompany", 50, "zhangsan");
        JedisUtil.getJedisUtil().zadd("qingshanCompany", 50, "lisi");
        JedisUtil.getJedisUtil().zadd("qingshanCompany", 50, "wangwu");
        JedisUtil.getJedisUtil().zadd("qingshanCompany", 50, "liuliu");

        //lisi给青山老师买了杯咖啡，加50分
        JedisUtil.getJedisUtil().zincrby("qingshanCompany",50,"lisi");
        //lily长得不错，加20分
        JedisUtil.getJedisUtil().zincrby("qingshanCompany",20,"lily");
        //wangwu 不听话，减10分
        JedisUtil.getJedisUtil().zincrby("qingshanCompany",-10,"wangwu");
        //liuliu说青山老师坏话，扣20
        JedisUtil.getJedisUtil().zincrby("qingshanCompany",-20,"liuliu");
        //张三拍青山老师马屁，加10分
        JedisUtil.getJedisUtil().zincrby("qingshanCompany",10,"zhangsan");
        //lucy不上班，开除
        JedisUtil.getJedisUtil().zrem("qingshanCompany","lucy");
        Set<String> set = JedisUtil.getJedisUtil().zrevrange("qingshanCompany", 0, -1);
        System.out.println("绩效从高到低："+set);// 从高到低

        //获取前3名，奖励100W
        Set<String> setTop3 = JedisUtil.getJedisUtil().zrevrange("qingshanCompany", 0, 2);
        System.out.println("前3名："+setTop3);
        //endregion

    }
}
