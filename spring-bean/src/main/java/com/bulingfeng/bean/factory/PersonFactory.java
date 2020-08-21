package com.bulingfeng.bean.factory;

import com.bulingfeng.ioc.container.overview.entity.Person;

/**
 * @Author:bulingfeng
 * @Date: 2020-08-19
 */
public interface PersonFactory {
    default Person createPerson(){
        Person  person=new Person();
        person.setAge(18);
        person.setName("bulingfeng-factory");
        return person;
    }

}
