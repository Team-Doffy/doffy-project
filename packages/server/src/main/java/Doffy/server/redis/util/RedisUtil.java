package Doffy.server.redis.util;


import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.time.Duration;

@RequiredArgsConstructor
@Service
public class RedisUtil {
    private final StringRedisTemplate template;
    public String getData(String key){
        ValueOperations<String,String> valueOperations = template.opsForValue();
        return valueOperations.get(key);
    }

    public boolean existData(String key){
        return Boolean.TRUE.equals(template.hasKey(key));
    }

    public void setDataExpire(String key, String value, long duration){
        ValueOperations<String,String> valueOperations = template.opsForValue();
        Duration expriedDuration = Duration.ofSeconds(duration);
        valueOperations.set(key,value,expriedDuration);
    }

    public void deleteData(String key){
        template.delete(key);
    }
}
