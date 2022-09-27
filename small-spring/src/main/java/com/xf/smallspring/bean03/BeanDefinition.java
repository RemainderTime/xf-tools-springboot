package com.xf.smallspring.bean03;

import lombok.Data;

/**
 * @program: xf-tools-springboot
 * @ClassName BeanDefinitaion
 * @description: 定义bean对象类
 * @author: xiongfeng
 * @create: 2022-09-22 10:15
 **/

@Data
public class BeanDefinition {

	private Class bean;

	public BeanDefinition(Class bean) {
		this.bean = bean;
	}
}
