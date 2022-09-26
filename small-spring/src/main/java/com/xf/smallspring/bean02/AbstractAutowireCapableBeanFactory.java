package com.xf.smallspring.bean02;

import lombok.extern.slf4j.Slf4j;

/**
 * @program: xf-tools-springboot
 * @ClassName AbstractAutowireCapableBeanFactory
 * @description:
 * @author: xiongfeng
 * @create: 2022-09-26 14:30
 **/
@Slf4j
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{


	@Override
	protected Object createBean(String beanName, BeanDefinition beanDefinition) {
		Object bean = null;
		try {
			bean = beanDefinition.getBean().newInstance();
		}catch (Exception e){
			log.error("获取bean的class对象异常", e);
		}

		addBeanDefinition(beanName, bean);
		return bean;
	}

}
