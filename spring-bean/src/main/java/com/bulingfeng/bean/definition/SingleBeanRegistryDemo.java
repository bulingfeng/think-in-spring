package com.bulingfeng.bean.definition;

import com.bulingfeng.bean.factory.DefaultPersonFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author:bulingfeng
 * @Date: 2020-08-21
 */
public class SingleBeanRegistryDemo {
    public static void main(String[] args) {
        // 1.创建beanfactory容器
        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext();

        DefaultPersonFactory defaultPersonFactory=new DefaultPersonFactory();
        ConfigurableListableBeanFactory beanFactory=applicationContext.getBeanFactory();
        beanFactory.registerSingleton("personFactory",defaultPersonFactory);

        // 启动spring上下文
        applicationContext.refresh();

        // 依赖查找
        DefaultPersonFactory personFactory=beanFactory.getBean("personFactory",DefaultPersonFactory.class);
        System.out.println("defaultPersonFactory == personFactory "+(defaultPersonFactory == personFactory));
        System.out.println("application上下文准备关闭......");
        applicationContext.close();
    }
}
