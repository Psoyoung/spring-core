package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
//@Component가 붙은 것을 다 스캔해서 스프링 빈으로 등록해줌
@ComponentScan (
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
        //Configuration도 스캔하기 떄문에 이건 뺴줌
)
public class AutoAppConfig {

}
