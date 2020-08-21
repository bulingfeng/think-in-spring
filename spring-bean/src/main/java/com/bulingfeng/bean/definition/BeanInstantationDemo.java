package com.bulingfeng.bean.definition;

import com.bulingfeng.ioc.container.overview.entity.Person;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author:bulingfeng
 * @Date: 2020-08-19
 */
public class BeanInstantationDemo {
    public static void main(String[] args) {
        BeanFactory beanFactory= new ClassPathXmlApplicationContext("classpath:/META-INF/bean-instantantion-context.xml");
        Person person=beanFactory.getBean("person-static-method", Person.class);
        System.out.println("通过静态方法来创建的bean对象为："+ person);


        // 通过工厂的方式来实例化对象
        Person person2=beanFactory.getBean("person-factory-method", Person.class);
        System.out.println("通过工厂的方式来实例化对象："+ person2);

        // 通过FactoryBean来创建bean
        Person person3=beanFactory.getBean("person-creation-by-factory-bean", Person.class);
        System.out.println("通过BeanFactory的方式来实例化对象："+ person3);
    }
}
