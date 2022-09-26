package com.xf.smallspring.bean02;

import org.junit.jupiter.api.Test;

class BeanFactoryTest {

	@Test
	public void beanTest(){
		// 1.初始化 BeanFactory
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		// 2.注册 bean
		BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
		beanFactory.registerBeanDefinition("userService", beanDefinition);
		// 3.第一次获取 bean
		UserService userService = (UserService) beanFactory.getBean("userService");
		userService.getUserInfo();
		// 4.第二次获取 bean from Singleton
		UserService userService_singleton = (UserService) beanFactory.getBean("userService");
		userService_singleton.getUserInfo();
	}

}