package com.bulingfeng.dependency.lookup;

import com.bulingfeng.ioc.container.overview.entity.Person;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author:bulingfeng
 * @Date: 2020-08-30
 */
public class TypeSafeDependencyLookupDemo {
    public static void main(String[] args) {
        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 将当前类 ObjectProviderDemo 作为配置类（Configuration Class）
        applicationContext.register(TypeSafeDependencyLookupDemo.class);
        // 启动应用上下文
        applicationContext.refresh();


        lookupByBeanFactory(applicationContext);
        lookupByObjectFactory(applicationContext);
        lookupByIfAvailiable(applicationContext);

        displayListableBeanFactoryGetBeansOfType(applicationContext);
        displayObjectProviderOps(applicationContext);

        // 关闭应用上下文
        applicationContext.close();
    }

    private static void displayObjectProviderOps(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<Person> objectProvider=applicationContext.getBeanProvider(Person.class);
        printBeanException("displayObjectProviderOps",()->objectProvider.stream().forEach(System.out::println));
    }


    private static void displayListableBeanFactoryGetBeansOfType(ListableBeanFactory applicationContext) {
        printBeanException("displayListableBeanFactoryGetBeansOfType",()->applicationContext.getBeansOfType(Person.class));
    }

    private static void lookupByIfAvailiable(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<Person>  objectProvider=applicationContext.getBeanProvider(Person.class);
        printBeanException("lookupByIfAvailiable",()->objectProvider.getIfAvailable());
    }

    private static void lookupByObjectFactory(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<Person>  objectProvider=applicationContext.getBeanProvider(Person.class);
        printBeanException("lookupByObjectFactory",()->objectProvider.getObject());
    }

    private static void lookupByBeanFactory(AnnotationConfigApplicationContext applicationContext) {
        printBeanException("lookupByBeanFactory",()->{
            applicationContext.getBean("person");
        });
    }


    private static void printBeanException(String message,Runnable runnable){
        System.out.println("现在是"+message+"调用方法");
        try {
            runnable.run();
        }catch (BeansException e){
            e.printStackTrace();
        }
    }

}
