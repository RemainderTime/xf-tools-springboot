package com.xf.smallspring.bean;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: xf-tools-springboot
 * @ClassName BeanFactory
 * @description: bean工厂类
 * @author: xiongfeng
 * @create: 2022-09-22 10:16
 **/
public class BeanFactory {

	private static Map<String,BeanDefinition> beanDefinitionList =new ConcurrentHashMap<>();

	public void setBean(String name, BeanDefinition bean){
		beanDefinitionList.put(name, bean);
	}

	public Object getBean(String name){
		return beanDefinitionList.get(name).getBean();
	}


}
