package com.xf.smallspring.bean03.strategy;

import com.xf.smallspring.bean03.BeanDefinition;
import com.xf.smallspring.bean03.InstantiationStrategy;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.NoOp;

import java.lang.reflect.Constructor;

/**
 * @program: xf-tools-springboot
 * @ClassName CgilbInstantiationStrategyImpl
 * @description: cgilb动态代理
 * @author: xiongfeng
 * @create: 2022-09-29 16:13
 **/
public class CgilbInstantiationStrategyImpl implements InstantiationStrategy {
	@Override
	public Object instantiation(BeanDefinition beanDefinition, String name, Constructor constructor, String... args) {
		Enhancer enhancer =new Enhancer();
		enhancer.setSuperclass(beanDefinition.getClass());
		enhancer.setCallback(new NoOp() {
			@Override
			public int hashCode() {
				return super.hashCode();
			}
		});
		if(constructor == null) return enhancer.create();
		return enhancer.create(constructor.getParameterTypes(), args);
	}
}
