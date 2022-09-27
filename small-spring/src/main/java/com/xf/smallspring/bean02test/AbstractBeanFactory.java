package com.xf.smallspring.bean02test;

import org.springframework.context.annotation.Bean;

/**
 * @program: xf-tools-springboot
 * @ClassName AbstractBeanFactory
 * @description:
 * @author: xiongfeng
 * @create: 2022-09-27 10:02
 **/
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegister implements BeanFactory {

	@Override
	public Object getBean(String beanName) {
		Object singleton = getSingleton(beanName);
		if(singleton != null){
			return singleton;
		}
		BeanDefinition beanDefinition = getBeanDefinition(beanName);

		return addCreate(beanName, beanDefinition);
	}

	protected abstract BeanDefinition getBeanDefinition(String name);

	protected abstract Object addCreate(String name, BeanDefinition beanDefinition);
}
