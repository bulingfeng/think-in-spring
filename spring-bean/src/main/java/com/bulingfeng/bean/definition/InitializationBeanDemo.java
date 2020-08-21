package com.bulingfeng.bean.definition;

import com.bulingfeng.bean.factory.DefaultPersonFactory;
import com.bulingfeng.bean.factory.PersonFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

/**
 * @Author:bulingfeng
 * @Date: 2020-08-20
 * 初始化bean
 *
 * 解决循环依赖问题：
 * https://www.jianshu.com/p/b65c57f4d45d
 */
public class InitializationBeanDemo {
    public static void main(String[] args) {
        // 1.创建beanfactory容器
        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext();

        // 2.把类注册到ioc容器中
        applicationContext.register(InitializationBeanDemo.class);
        // 启动spring上下文
        applicationContext.refresh();

        // 通过类型来获取bean
//        PersonFactory personFactory=applicationContext.getBean(PersonFactory.class);
//        System.out.println("获取到的类型为:"+personFactory);

        System.out.println("application上下文准备关闭......");
        applicationContext.close();
        System.out.println("application上下文已经关闭......");
    }


    @Bean(initMethod="initPerson",destroyMethod = "doDestroy")
    @Lazy
    public DefaultPersonFactory personFactory(){
        return new DefaultPersonFactory();
    }

}
