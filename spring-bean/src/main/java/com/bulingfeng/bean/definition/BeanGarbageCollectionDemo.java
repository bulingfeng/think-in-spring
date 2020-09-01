package com.bulingfeng.bean.definition;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author:bulingfeng
 * @Date: 2020-08-21
 */
public class BeanGarbageCollectionDemo {
    public static void main(String[] args) throws InterruptedException {
        // 1.创建beanfactory容器
        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext();

        // 2.把类注册到ioc容器中
        applicationContext.register(InitializationBeanDemo.class);
        // 启动spring上下文
        applicationContext.refresh();

        System.out.println("application上下文准备关闭......");
        applicationContext.close();
        Thread.sleep(5000L);
        // 强制执行GC 但是不一定一定会执行finalize方法
        // 所以在调用回收的时候sleep一段时间 尽量大的可能来回调finalize方法
        System.gc();
        Thread.sleep(1000L);
    }
}
