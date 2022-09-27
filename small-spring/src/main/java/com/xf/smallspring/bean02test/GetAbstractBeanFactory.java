package com.xf.smallspring.bean02test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: xf-tools-springboot
 * @ClassName GetAbstractBeanFactory
 * @description:
 * @author: xiongfeng
 * @create: 2022-09-27 10:14
 **/
public class GetAbstractBeanFactory extends AutoWiredAbstractBeanFactory implements BeanDefinitionRegister {

	private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

	@Override
	protected BeanDefinition getBeanDefinition(String name) {
		return beanDefinitionMap.get(name);
	}

	@Override
	public void addBeanDefinition(String name, BeanDefinition beanDefinition) {
		beanDefinitionMap.put(name, beanDefinition);
	}
}
