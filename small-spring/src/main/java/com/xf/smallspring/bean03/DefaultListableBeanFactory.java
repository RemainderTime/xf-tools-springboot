package com.xf.smallspring.bean03;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: xf-tools-springboot
 * @ClassName DefaultListableBeanFactory
 * @description:
 * @author: xiongfeng
 * @create: 2022-09-26 14:34
 **/
@Slf4j
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry {

	private Map<String, BeanDefinition> beanDefinitionMap =new ConcurrentHashMap<>();

	@Override
	protected BeanDefinition getBeanDefinition(String beanName) {
		BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
		if(beanDefinition == null){
			log.error("获取bean对象失败");
		}
		return beanDefinition;
	}

	@Override
	public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
		beanDefinitionMap.put(beanName, beanDefinition);
	}
}
