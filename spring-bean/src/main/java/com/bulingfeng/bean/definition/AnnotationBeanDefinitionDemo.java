package com.bulingfeng.bean.definition;

import com.bulingfeng.ioc.container.overview.entity.Person;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import static org.springframework.beans.factory.support.BeanDefinitionBuilder.genericBeanDefinition;

/**
 * @Author:bulingfeng
 * @Date: 2020-08-19
 */
@Import(value=AnnotationBeanDefinitionDemo.Config.class)
public class AnnotationBeanDefinitionDemo {
    public static void main(String[] args) {
        // 1.创建beanfactory容器
        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext();

        // 2.把类注册到ioc容器中
        applicationContext.register(AnnotationBeanDefinitionDemo.class);

        // 通过api的方式进行注册
        registerPersonBeanDefinition(applicationContext,"MR.JOBS");

        // 2. 启动spring上下文
        applicationContext.refresh();

        // 按照类来依赖查找
        System.out.println("获取到person的对象有:"+applicationContext.getBeansOfType(Person.class));
        System.out.println("获取到Config的对象有:"+applicationContext.getBeansOfType(AnnotationBeanDefinitionDemo.Config.class));
        System.out.println("通过名称来获取config:"+applicationContext.getBean("com.bulingfeng.bean.definition.AnnotationBeanDefinitionDemo$Config"));




    }

    /**
     * 通过名称来进行注解
     * @param registry
     * @param beanName
     */
    public static void registerPersonBeanDefinition(BeanDefinitionRegistry registry,String beanName){
        BeanDefinitionBuilder beanDefinitionBuilder=genericBeanDefinition(Person.class);
        beanDefinitionBuilder.addPropertyValue("name","bulingfeng")
                .addPropertyValue("age",18);

        if (StringUtils.hasText(beanName)){
            // 注册 BeanDefinition
            registry.registerBeanDefinition(beanName,beanDefinitionBuilder.getBeanDefinition());
        }else {
            // 没有指定名称来进行注册
            BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinitionBuilder.getBeanDefinition(),registry);
        }
    }



    @Component
    public static class Config{
        @Bean(name = {"bulingfeng-person"})
        public Person person(){
            Person person=new Person();
            person.setName("bulingfeng");
            person.setAge(18);
            return person;
        }
    }
}
