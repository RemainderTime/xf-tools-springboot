package com.xf.smallspring.bean03;

/**
 * @program: xf-tools-springboot
 * @ClassName BeanFactory
 * @description: bean工厂类
 * @author: xiongfeng
 * @create: 2022-09-22 10:16
 **/
public interface BeanFactory {


	Object getBean(String name);

	//new  -- 03
	Object getBean(String name, String ...args);

}
