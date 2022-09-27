package com.xf.smallspring.bean02test;

import lombok.Data;

/**
 * @program: xf-tools-springboot
 * @ClassName BeanDefinition
 * @description:
 * @author: xiongfeng
 * @create: 2022-09-27 09:29
 **/

@Data
public class BeanDefinition {

	private Class beanClass;


	public BeanDefinition(Class beanClass) {
		this.beanClass = beanClass;
	}
}
