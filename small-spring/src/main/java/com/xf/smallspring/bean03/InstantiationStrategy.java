package com.xf.smallspring.bean03;

import java.lang.reflect.Constructor;

public interface InstantiationStrategy {

	public void instantiation(BeanDefinition beanDefinition, String name, Constructor constructor, String ...args);
}
