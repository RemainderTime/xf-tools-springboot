package com.xf.smallspring.bean;

import org.junit.jupiter.api.Test;

class BeanFactoryTest {

	@Test
	public void beanTest(){
		//初始化bean工厂
		BeanFactory factory =new BeanFactory();

		//注册bean
		BeanDefinition beanDefinition =new BeanDefinition(new UserService());
		factory.setBean("userService", beanDefinition);

		//获取bean
		UserService userService = (UserService) factory.getBean("userService");
		userService.getUserInfo();
	}

}