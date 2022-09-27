package com.xf.smallspring.bean02test;

import org.junit.jupiter.api.Test;

/**
 * @program: xf-tools-springboot
 * @ClassName Main
 * @description:
 * @author: xiongfeng
 * @create: 2022-09-27 14:24
 **/
public class Main {

	@Test
	public void test(){
		GetAbstractBeanFactory factory =new GetAbstractBeanFactory();

		BeanDefinition beanDefinition =new BeanDefinition(UserService.class);
		factory.addBeanDefinition("userService", beanDefinition);

		//第一次
		UserService userService = (UserService) factory.getBean("userService");
		userService.queryInfo();

		//第二次
		UserService userService02 = (UserService) factory.getBean("userService");
		userService02.queryInfo();

	}
}
