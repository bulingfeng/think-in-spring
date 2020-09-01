package com.bulingfeng.dependency.lookup;

import com.bulingfeng.ioc.container.overview.container.AnnotationIocContainerDemo;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.HierarchicalBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author:bulingfeng
 * @Date: 2020-08-29
 * 该类的目的为分层次查找bean。
 */
public class HierarchicalLookupDemo {
    public static void main(String[] args) {
        // 1.创建beanfactory容器
        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext();

        // 2.把类注册到ioc容器中
        applicationContext.register(AnnotationIocContainerDemo.class);

        ConfigurableListableBeanFactory beanFactory=applicationContext.getBeanFactory();
        System.out.println("当前beanFactory 的 parentFactory ："+beanFactory.getParentBeanFactory());

        // 3. 配置 bean factory的父类
        HierarchicalBeanFactory configurableListableBeanFactory1=createParentBeanFactory();
        beanFactory.setParentBeanFactory(configurableListableBeanFactory1);


        displayLocalBean(beanFactory,"person");
        displayLocalBean(configurableListableBeanFactory1,"person");








        // 2. 启动spring上下文
        applicationContext.refresh();
    }


    private  static void displayLocalBean(HierarchicalBeanFactory beanFactory,String beanName){
        System.out.printf("当前beanfactory[%s],是否存在beanname为[%s]:%s\n",beanFactory,beanName,beanFactory.containsBean(beanName));
    }


    private static HierarchicalBeanFactory createParentBeanFactory(){
        DefaultListableBeanFactory defaultListableBeanFactory=new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(defaultListableBeanFactory);
        String location="/META-INF0/ioc-dependency-injection.xml";
        reader.loadBeanDefinitions(location);
        return defaultListableBeanFactory;
    }
}
