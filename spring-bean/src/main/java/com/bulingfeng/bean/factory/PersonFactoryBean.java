package com.bulingfeng.bean.factory;

import com.bulingfeng.ioc.container.overview.entity.Person;
import org.springframework.beans.factory.FactoryBean;

/**
 * @Author:bulingfeng
 * @Date: 2020-08-19
 */
public class PersonFactoryBean implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        return Person.createPerson();
    }

    @Override
    public Class<?> getObjectType() {
        return Person.class;
    }
}
