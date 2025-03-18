package com.xiehao.common;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisConnectionFactory {
    private static final JedisPool jedisPool;

    static{
        JedisPoolConfig config = new JedisPoolConfig();
        //最大连接
        config.setMaxTotal(8);
        //最大空闲连接
        config.setMaxIdle(8);
        //最小空闲连接
        config.setMinIdle(0);
        //设置最长等待时间
        config.setMaxWaitMillis(200);
        jedisPool = new JedisPool(config, "192.168.31.213", 6379,1000,"200404");

    }

    //获取jedis对象
    public static Jedis getJedis(){
        return jedisPool.getResource();
    }

}
