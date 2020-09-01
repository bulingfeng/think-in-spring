package com.bulingfeng.bean.factory;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Author:bulingfeng
 * @Date: 2020-08-19
 * 初始化顺序 @PostConstruct>afterPropertiesSet>initPerson
 */
public class DefaultPersonFactory implements PersonFactory, InitializingBean, DisposableBean {

    // 基于PostConstruct来进行bean对象的初始化，这种方式是该注解的默认方式
    @PostConstruct
    public void init(){
        System.out.println("@PostConstruct 正在进行初始化......");
    }


    public void initPerson(){
        System.out.println("initPerson 正在进行初始化......");
    }

    // 这个是必须实现的方法
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet 正在进行初始化......");
    }


    public void destroy(){
        System.out.println("使用 DisposableBean#destroy 销毁对象 DefaultPersonFactory..... ");
    }

    @PreDestroy
    public void destroy2(){
        System.out.println("使用 @PreDestroy 销毁对象 DefaultPersonFactory..... ");
    }

    public void doDestroy(){
        System.out.println("使用 自定义方式 销毁对象 DefaultPersonFactory..... ");
    }

    @Override
    public void finalize() throws Throwable {
        System.out.println("DefaultPersonFactory 正在被回收.......");
    }
}
