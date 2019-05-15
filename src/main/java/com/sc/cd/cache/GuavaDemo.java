package com.sc.cd.cache;

import java.util.concurrent.TimeUnit;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;

/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2018-12-27 18:05
 */
public class GuavaDemo {

    public static void main(String[] args) {

        LoadingCache<String,Student> studentCache
                = CacheBuilder.newBuilder()
                .concurrencyLevel(8)
                .expireAfterWrite(5, TimeUnit.MINUTES)
                .initialCapacity(10)
                .maximumSize(100)
                .recordStats()
                .removalListener(new RemovalListener<Object, Object>() {
                    @Override
                    public void onRemoval(RemovalNotification<Object, Object> notification) {
                        System.out.println(notification.getKey() + " was removed, cause is " + notification.getCause());
                    }
                })
                .build(new CacheLoader<String, Student>() {
                    @Override
                    public Student load(String s) throws Exception {
                        return null;
                    }
                });
        studentCache.put("j",new Student(1,"11"));
        studentCache.put("j1",new Student(1,"12"));
        studentCache.put("j2",new Student(1,"13"));
        studentCache.put("j3",new Student(1,"14"));
        studentCache.put("111",new Student(1,"15"));


        try{
            for (int i=0;i<20;i++) {
                //从缓存中得到数据，由于我们没有设置过缓存，所以需要通过CacheLoader加载缓存数据
                Student student = studentCache.get("111");
                System.out.println(student);
                //休眠1秒
                TimeUnit.SECONDS.sleep(1);
            }

            System.out.println("cache stats:");
            //最后打印缓存的命中率等 情况
            System.out.println(studentCache.stats().toString());
        }catch (Exception ex){

        }

    }
}
