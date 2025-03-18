package com.xiehao;

import com.xiehao.common.JedisConnectionFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;

@SpringBootTest
class LRedisApplicationTests {

    private Jedis jedis;

    //1.引入依赖
    //2.建立连接

    @BeforeEach
    void setUp() {
        jedis = JedisConnectionFactory.getJedis();
        jedis.auth("200404");
        jedis.select(0);
    }

    @Test
    void testString(){
        String result = jedis.set("name","lsi");
        System.out.println(result);
        String name = jedis.get("name");
        System.out.println(name);
    }

    @Test
    void testHash(){

    }

    @AfterEach
    void tearDown() {
        if (jedis != null) {
            jedis.close();
        }
    }

}
