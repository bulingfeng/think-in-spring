package com.bulingfeng.ioc.container.overview.dependency.Injection;

import com.bulingfeng.ioc.container.overview.reposity.RepositoryPerson;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author:bulingfeng
 * @Date: 2020-08-17
 */
public class InjectionTest {
    public static void main(String[] args) {
        BeanFactory beanFactory=new ClassPathXmlApplicationContext("/META-INF0/ioc-dependency-injection.xml");
        RepositoryPerson repositoryPerson=beanFactory.getBean(RepositoryPerson.class);
        RepositoryPerson repositoryPerson2=(RepositoryPerson)beanFactory.getBean("repositoryPerson");
        System.out.println(repositoryPerson2);


        // 判断依赖注入中和依赖查找的beanfactory是不是一个bean
        System.out.println(repositoryPerson2.getBeanFactory()==beanFactory);

        // 依赖注入
        System.out.println(repositoryPerson2.getBeanFactory());
        // 依赖查找
        System.out.println(beanFactory);
    }
}
