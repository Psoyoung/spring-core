package hello.core.scope;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.assertThat;

public class PrototypeTest {

    @Test
    void prototypeBeanFind(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeTest.prototypeBean.class);

        prototypeBean bean1 = ac.getBean(prototypeBean.class);
        prototypeBean bean2 = ac.getBean(prototypeBean.class);
        System.out.println("bean1 = " + bean1);
        System.out.println("bean2 = " + bean2);
        assertThat(bean1).isNotSameAs(bean2);

        bean1.destroy();
        bean2.destroy();
        ac.close();
    }

    @Scope("prototype")
    static class prototypeBean{
        @PostConstruct
        public void init()  {
            System.out.println("prototypeBean.init");

        }

        @PreDestroy
        public void destroy(){
            System.out.println("prototypeBean.destroy");
        }
    }
}
