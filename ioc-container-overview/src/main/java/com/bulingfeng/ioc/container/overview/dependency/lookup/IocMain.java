package com.bulingfeng.ioc.container.overview.dependency.lookup;

import com.bulingfeng.ioc.container.overview.annotation.Super;
import com.bulingfeng.ioc.container.overview.entity.Person;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @Author:bulingfeng
 * @Date: 2020-08-16
 * 以下都是进行的依赖查找。
 * 1、通过名称和类型来查找
 * 2、通过集合来查找
 * 3、通过注解来进行查找
 */
public class IocMain {
    public static void main(String[] args) {
       BeanFactory beanFactory= new ClassPathXmlApplicationContext("META-INF0/ioc-lookup.xml");
        lookupReal(beanFactory);
        lookupLazy(beanFactory);
        // 按照类型查找 如果出现id为多个的class就会报错
        lookupByType(beanFactory);

        lookupCollectionByType(beanFactory);

        // 通过注解来找到
        lookupByAnnotationType(beanFactory);
    }

    private static void lookupByAnnotationType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory= (ListableBeanFactory) beanFactory;
            // map中的key为bean中的id
            Map<String, Person> map=(Map)listableBeanFactory.getBeansWithAnnotation(Super.class);
            System.out.println("通过@super 注解来来获取对象的"+map);
        }
    }

    private static void lookupCollectionByType(BeanFactory beanFactory) {
        ListableBeanFactory listableBeanFactory= (ListableBeanFactory) beanFactory;
        // map中的key为bean中的id
        Map<String,Person> map=listableBeanFactory.getBeansOfType(Person.class);
        System.out.println("通过类型来获取对象集合："+map);
    }

    private static void lookupByType(BeanFactory beanFactory) {
        Person person=beanFactory.getBean(Person.class);
        System.out.println("通过类型来查找："+person);
    }


    static void lookupReal(BeanFactory factory){
        Person person=factory.getBean("person",Person.class);
        System.out.println(person);
    }

    static void lookupLazy(BeanFactory factory){
        ObjectFactory<Person> objectFactory=(ObjectFactory<Person>)factory.getBean("objectFactoryCreatingFactoryBean");
        Object object=objectFactory.getObject();
        System.out.println(object);
    }
}
