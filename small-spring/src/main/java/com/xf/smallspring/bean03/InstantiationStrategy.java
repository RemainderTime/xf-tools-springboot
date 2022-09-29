package com.xf.smallspring.bean03;

import org.springframework.beans.BeansException;

import java.lang.reflect.Constructor;

public interface InstantiationStrategy {

	Object instantiation(BeanDefinition beanDefinition, String name, Constructor constructor, String ...args) throws BeansException;
}
