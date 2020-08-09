//package com.xd.config;
//
//import com.fasterxml.jackson.annotation.JsonAutoDetect;
//import com.fasterxml.jackson.annotation.PropertyAccessor;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.core.env.Environment;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
//
//
//
//
//@Configuration
//@PropertySource("classpath:config/redis.properties")
//public class RedisConfig {
//
////    @Autowired
////    private Environment environment;
//
//    @Bean
//    public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory factory){
//        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Object>(Object.class);
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
//
//        RedisTemplate<String,Object> template = new RedisTemplate<>();
//        template.setConnectionFactory(factory);
//        template.setKeySerializer(jackson2JsonRedisSerializer);
//        template.setValueSerializer(jackson2JsonRedisSerializer);
//        template.setHashValueSerializer(jackson2JsonRedisSerializer);
//        template.setHashKeySerializer(jackson2JsonRedisSerializer);
//        template.afterPropertiesSet();
//
//        return template;
//    }
//
//
////    @Bean
////    public RedisConnectionFactory redisConnectionFactory() {
////        JedisConnectionFactory fac = new JedisConnectionFactory();
////        fac.setHostName(environment.getProperty("redis.hostName"));
////        fac.setPort(Integer.parseInt(environment.getProperty("redis.port")));
////        fac.setPassword(environment.getProperty("redis.password"));
////        fac.setTimeout(Integer.parseInt(environment.getProperty("redis.timeout")));
////        fac.getPoolConfig().setMaxIdle(Integer.parseInt(environment.getProperty("redis.maxIdle")));
////        fac.getPoolConfig().setMaxTotal(Integer.parseInt(environment.getProperty("redis.maxTotal")));
////        fac.getPoolConfig().setMaxWaitMillis(Integer.parseInt(environment.getProperty("redis.maxWaitMillis")));
////        fac.getPoolConfig().setMinEvictableIdleTimeMillis(
////                Integer.parseInt(environment.getProperty("redis.minEvictableIdleTimeMillis")));
////        fac.getPoolConfig()
////                .setNumTestsPerEvictionRun(Integer.parseInt(environment.getProperty("redis.numTestsPerEvictionRun")));
////        fac.getPoolConfig().setTimeBetweenEvictionRunsMillis(
////                Integer.parseInt(environment.getProperty("redis.timeBetweenEvictionRunsMillis")));
////        fac.getPoolConfig().setTestOnBorrow(Boolean.parseBoolean(environment.getProperty("redis.testOnBorrow")));
////        fac.getPoolConfig().setTestWhileIdle(Boolean.parseBoolean(environment.getProperty("redis.testWhileIdle")));
////        return fac;
////    }
//
//    @Bean
//    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory factory){
//        StringRedisTemplate template = new StringRedisTemplate();
//        template.setConnectionFactory(factory);
//
//        return template;
//    }
//
//
//}
