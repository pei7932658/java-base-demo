package com.sy.guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @Author:peiliang
 * @Description:
 * @Date:2019/11/19 21:46
 * @Modified By:
 * @Version: 1.0
 */
public class LoadingCacheTest {
    public static void main(String[] args) throws ExecutionException {
        LoadingCache<String, List<Token>> userTokenCache = CacheBuilder.newBuilder()
                .maximumSize(2)
//                .expireAfterAccess(1,TimeUnit.SECONDS)
                .expireAfterWrite(1, TimeUnit.SECONDS)
                .build(
                        new CacheLoader<String, List<Token>>() {
                            @Override
                            public List<Token> load(String s) throws Exception {
                                return cachePull();
//                                return null;
                            }
                        }
                );
        //get 方法，如果userTokenCache 没有对应的key，那就会调用load 方法，初始经cache，并且Key=userCacheKey,返回结果为整个value
//        System.out.println(userTokenCache.get("userCacheKey"));
//        System.out.println(userTokenCache.get("userCacheKey").get(1).toString());

        //getIfPresent 方法，如果userTokenCache 没有对应的key,返回结果为null
//        System.out.println(userTokenCache.getIfPresent("userCacheKey"));
//        System.out.println(userTokenCache.getIfPresent("userCacheKey").get(1).toString()); //NullPointerException

//        userTokenCache.get("userCacheKey");
//        System.out.println(userTokenCache.size());
//        userTokenCache.invalidate("userCacheKey"); //会让对应key的缓存失效
//        System.out.println(userTokenCache.size());


        //当put的值超过 maximumSize 大小时,后面put进去的值覆盖前面的缓存
//        userTokenCache.get("userCacheKey");
//        userTokenCache.put("appCacheKey", Arrays.asList(
//                new Token("appToken1",1*1000l),
//                new Token("appToken2",2*1000l),
//                new Token("appToken3",3*1000l)
//        ));
//        System.out.println(userTokenCache.size());
//        System.out.println(userTokenCache.getIfPresent("appCacheKey").size()); //这里只有新key

        //expireAfterWrite 缓存项在给定时间内没有被写访问（创建或覆盖），则回收。如果认为缓存数据总是在固定时候后变得陈旧不可用，这种回收方式是可取的
        //expireAfterAccess 缓存项在给定时间内没有被读/写访问，则回收。请注意这种缓存的回收顺序和基于大小回收一样
        userTokenCache.get("userCacheKey");
//        userTokenCache.put("appCacheKey", Arrays.asList(
//                new Token("appToken1",1*1000l),
//                new Token("appToken2",2*1000l),
//                new Token("appToken3",3*1000l)
//        ));
        System.out.println(userTokenCache.size());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        System.out.println(userTokenCache.getIfPresent("userCacheKey"));//注意key在，只是value为空

        //当maximumSize 改成足够大
//        userTokenCache.refresh("user1");
//        System.out.println(userTokenCache.size());
    }

    private static List<Token> cachePull() {
        List<Token> tokens = new ArrayList<>();
        tokens.add(new Token("token1", 3 * 1000l));
        tokens.add(new Token("token2", 4 * 1000l));
        tokens.add(new Token("token3", 5 * 1000l));
        tokens.add(new Token("token4", 5 * 1000l));
        tokens.add(new Token("token5", 5 * 1000l));
        tokens.add(new Token("token6", 5 * 1000l));
        tokens.add(new Token("token7", 5 * 1000l));
        return tokens;
    }
}
