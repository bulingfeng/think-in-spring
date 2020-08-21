package com.bulingfeng.ioc.container.overview.container;

import com.bulingfeng.ioc.container.overview.annotation.Super;
import com.bulingfeng.ioc.container.overview.entity.Person;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * @Author:bulingfeng
 * @Date: 2020-08-17
 */
public class IocContainerDemo {
    public static void main(String[] args) {
        DefaultListableBeanFactory defaultListableBeanFactory=new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(defaultListableBeanFactory);
        String location="/META-INF0/ioc-dependency-injection.xml";
        int beanNum=reader.loadBeanDefinitions(location);
        System.out.println("bean num is "+beanNum);

        lookupCollectionByType(defaultListableBeanFactory);

    }


    private static void lookupCollectionByType(BeanFactory beanFactory) {
        ListableBeanFactory listableBeanFactory= (ListableBeanFactory) beanFactory;
        // map中的key为bean中的id
        Map<String,Person> map=listableBeanFactory.getBeansOfType(Person.class);
        System.out.println("通过类型来获取对象集合："+map);
    }
}
