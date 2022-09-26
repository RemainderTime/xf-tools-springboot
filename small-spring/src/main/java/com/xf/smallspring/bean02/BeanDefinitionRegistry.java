package com.xf.smallspring.bean02;

public interface BeanDefinitionRegistry {

	/**
	 * 向注册表中注册 BeanDefinition
	 *
	 * @param beanName
	 * @param beanDefinition
	 */
	void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

}
