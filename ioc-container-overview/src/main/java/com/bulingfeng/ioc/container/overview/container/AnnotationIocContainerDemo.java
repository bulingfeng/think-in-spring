package com.bulingfeng.ioc.container.overview.container;

import com.bulingfeng.ioc.container.overview.entity.Person;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Map;

/**
 * @Author:bulingfeng
 * @Date: 2020-08-17
 */
public class AnnotationIocContainerDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext=new
                AnnotationConfigApplicationContext();
        // 把当前类作为配置类
        annotationConfigApplicationContext.register(AnnotationIocContainerDemo.class);
        // 启动上下文的唯一方式，看似是refresh，实际是是启动
        annotationConfigApplicationContext.refresh();
        lookupCollectionByType(annotationConfigApplicationContext);

        // 关闭
        annotationConfigApplicationContext.close();
    }

    @Bean
    public Person person(){
        Person p=new Person();
        p.setAge(18);
        p.setName("bulingfeng");
        return p;
    }
    private static void lookupCollectionByType(BeanFactory beanFactory) {
        ListableBeanFactory listableBeanFactory= (ListableBeanFactory) beanFactory;
        // map中的key为bean中的id
        Map<String, Person> map=listableBeanFactory.getBeansOfType(Person.class);
        System.out.println("通过类型来获取对象集合："+map);
    }
}
