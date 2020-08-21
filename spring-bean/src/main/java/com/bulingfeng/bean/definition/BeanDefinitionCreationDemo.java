package com.bulingfeng.bean.definition;

import com.bulingfeng.ioc.container.overview.entity.Person;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * @Author:bulingfeng
 * @Date: 2020-08-18
 * {@link BeanDefinitionCreationDemo}
 */
public class BeanDefinitionCreationDemo {
    public static void main(String[] args) {
        // 1.通过 BeanDefinitionBuilder构建
        BeanDefinitionBuilder beanDefinitionBuilder=BeanDefinitionBuilder.genericBeanDefinition(Person.class);
        // 设置属性
        beanDefinitionBuilder.addPropertyValue("name","bulingfeng");
        beanDefinitionBuilder.addPropertyValue("age",18);
        // 创建BeanDefinition
       BeanDefinition beanDefinition= beanDefinitionBuilder.getBeanDefinition();
        System.out.println("BeanDefinitionBuilder来创建 BeanDefinition："+beanDefinition);


        // 2.通过AbstractBeanDefinition以及衍生类来创建
        GenericBeanDefinition genericBeanDefinition=new GenericBeanDefinition();
        genericBeanDefinition.setBeanClass(Person.class);
        MutablePropertyValues mutablePropertyValues=new MutablePropertyValues();
        mutablePropertyValues.add("name","bulingfeng").add("age",18);
        genericBeanDefinition.setPropertyValues(mutablePropertyValues);




    }
}
