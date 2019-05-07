package example.redis;

/**
 * redis java API使用示例
 */

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;

public class RedisJava {
    public static void main(String[] args) {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功\n");
        //查看服务是否运行
        System.out.println("服务正在运行: "+jedis.ping()+"\n");
        
        System.out.println("======================\n\n");
        
        //设置字符串数据
        jedis.set("runoobkey", "www.runoob.com");
        //获取存储的字符串
        System.out.println("redis存储的字符串为："+jedis.get("runoobkey")+"\n");
        
        System.out.println("======================\n\n");
        
        //存储数据到列表中
        jedis.lpush("site-list", "Runoob");
        jedis.lpush("site-list", "Google");
        jedis.lpush("site-list", "Taobao");
        // 获取存储的数据并输出
        List<String> list = jedis.lrange("site-list", 0 ,2);
        for(int i=0; i<list.size(); i++) {
            System.out.println("列表项为: "+list.get(i)+"\n");
        }
        
        System.out.println("======================\n\n");
        
        // 获取数据并输出
        Set<String> keys = jedis.keys("*"); 
        Iterator<String> it=keys.iterator() ;   
        while(it.hasNext()){   
            String key = it.next();   
            System.out.println(key+"\n");   
        }
    }
}

















