package com.xf.smallspring.bean02test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: xf-tools-springboot
 * @ClassName DefualtSingletonBeanRegister
 * @description:
 * @author: xiongfeng
 * @create: 2022-09-27 09:55
 **/
public class DefaultSingletonBeanRegister implements SingletonBeanRegister {

	private Map<String, Object> singletonMap =new ConcurrentHashMap<>();

	@Override
	public Object getSingleton(String name) {
		return singletonMap.get(name);
	}

	protected void addSingleton(String name, Object bean){
		singletonMap.put(name, bean);
	}
}
