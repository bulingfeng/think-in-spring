package com.bulingfeng.bean.definition;

import com.bulingfeng.ioc.container.overview.entity.Person;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author:bulingfeng
 * @Date: 2020-08-19
 * 通过别名来获取bean
 */
public class BeanAliasDemo {
    public static void main(String[] args) {
        BeanFactory beanFactory=new ClassPathXmlApplicationContext("classpath:/META-INF/bean-definitions-context.xml");
        Person person =beanFactory.getBean("person",Person.class);
        Person alisPerson=beanFactory.getBean("bulingfeng-person",Person.class);
        System.out.println("person 和 alisPerson 是否相等:"+ (person== alisPerson));
    }
}
