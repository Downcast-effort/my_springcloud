package rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhanghab
 * @date 2021/8/17
 * @description:
 **/
@Configuration
public class MyRule {

    @Bean
    public IRule myRule(){
        return new RandomRule();
    }
}
