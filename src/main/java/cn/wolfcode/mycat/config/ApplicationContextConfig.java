package cn.wolfcode.mycat.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author huteng5
 * @version 1.0
 * @date 2021/8/13 17:22
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    //@LoadBalanced
    /**
     * 使用默认的负载规则需加上@LoadBalanced
     * 使用自定义轮询规则需要注掉@LoadBalanced
     */
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
