package com.xf.smallspring.bean03.strategy;

import com.xf.smallspring.bean03.BeanDefinition;
import com.xf.smallspring.bean03.InstantiationStrategy;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Constructor;

/**
 * @program: xf-tools-springboot
 * @ClassName JDKInstantiationStrategyImpl
 * @description: jdk实现
 * @author: xiongfeng
 * @create: 2022-09-29 16:13
 **/
@Slf4j
public class JDKInstantiationStrategyImpl implements InstantiationStrategy {
	@Override
	public Object instantiation(BeanDefinition beanDefinition, String name, Constructor constructor, String... args) {

		Class<? extends BeanDefinition> aClass = beanDefinition.getClass();
		try {
			if(constructor != null){
				return aClass.getDeclaredConstructor(aClass.getComponentType()).newInstance(args);
			}else {
				return aClass.getDeclaredConstructor().newInstance(args);
			}
		}catch (Exception e){
			log.error("jdk实现构造函数携带参数异常---", e);
		}
		return null;
	}
}
