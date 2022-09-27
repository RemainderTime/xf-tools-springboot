package com.xf.smallspring.bean02test;

import lombok.extern.slf4j.Slf4j;

/**
 * @program: xf-tools-springboot
 * @ClassName AutoWiredAbstractBeanFactory
 * @description:
 * @author: xiongfeng
 * @create: 2022-09-27 10:07
 **/
@Slf4j
public abstract class AutoWiredAbstractBeanFactory extends AbstractBeanFactory {

	@Override
	protected Object addCreate(String name, BeanDefinition beanDefinition) {

		Object bean = null;
		try {
			bean = beanDefinition.getBeanClass().newInstance();
		}catch (Exception e){
			log.error("获取bean实例异常");
		}
		addSingleton(name, bean);
		return bean;
	}
}
