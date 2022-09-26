package com.xf.smallspring.bean02;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: xf-tools-springboot
 * @ClassName DefultSingletonBeanRegister
 * @description:
 * @author: xiongfeng
 * @create: 2022-09-26 10:30
 **/
public class DefaultSingletonBeanRegister implements SingletonBeanRegister{

	private Map<String,Object> beanDefinitionMap =new ConcurrentHashMap<>();

	@Override
	public Object getSingleton(String beanName) {
		return beanDefinitionMap.get(beanName);
	}

	protected void addBeanDefinition(String beanName,  Object beanDefinition){
		beanDefinitionMap.put(beanName, beanDefinition);
	}
}
