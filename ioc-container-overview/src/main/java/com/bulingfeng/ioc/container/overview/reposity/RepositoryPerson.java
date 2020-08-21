package com.bulingfeng.ioc.container.overview.reposity;

import com.bulingfeng.ioc.container.overview.entity.Person;
import org.springframework.beans.factory.BeanFactory;

import java.util.Collection;

/**
 * @Author:bulingfeng
 * @Date: 2020-08-17
 */
public class RepositoryPerson {
    private Collection<Person> people;

    // 测试依赖注入
    private BeanFactory beanFactory;

    public Collection<Person> getPeople() {
        return people;
    }

    public void setPeople(Collection<Person> people) {
        this.people = people;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    @Override
    public String toString() {
        return "RepositoryPerson{" +
                "people=" + people +
                '}';
    }
}
