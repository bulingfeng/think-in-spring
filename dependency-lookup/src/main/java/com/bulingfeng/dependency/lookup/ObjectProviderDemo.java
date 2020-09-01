package com.bulingfeng.dependency.lookup;

import com.bulingfeng.ioc.container.overview.entity.Person;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

/**
 * @Author:bulingfeng
 * @Date: 2020-08-29
 * 实现延迟查找
 * 延迟查找的含义就是不是直接获取到bean，而是间接的获取到bean
 */
public class ObjectProviderDemo {
    public static void main(String[] args) {
        // 1.创建beanfactory容器
        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext();

        // 2.把类注册到ioc容器中
        applicationContext.register(ObjectProviderDemo.class);




        // 2. 启动spring上下文
        applicationContext.refresh();
        getBeanByObjectFactory(applicationContext);

        lookupIfAvailable(applicationContext);
        lookupByStreamOps(applicationContext);
    }

    private static void lookupByStreamOps(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<String> objectProvider=applicationContext.getBeanProvider(String.class);
        objectProvider.stream().forEach(e->{
            System.out.println("获取到所有的string对象为:"+e);
        });
    }

    private static void lookupIfAvailable(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<Person> objectProvider=applicationContext.getBeanProvider(Person.class);
        Person person=objectProvider.getIfAvailable(()->Person.createPerson());
        System.out.println("现有的person对象为:"+person);
    }


    @Bean
    @Primary
    public String helloWorld(){
        return  "hello,world";
    }


    @Bean
    public String message(){
        return "message";
    }


    private static void getBeanByObjectFactory(ApplicationContext applicationContext){
        ObjectProvider<String> objectProvider=applicationContext.getBeanProvider(String.class);
        System.out.println("延迟查找得到的结果为:"+objectProvider.getObject());
    }

}
