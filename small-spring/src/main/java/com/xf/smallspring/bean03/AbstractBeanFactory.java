package com.xf.smallspring.bean03;

/**
 * @program: xf-tools-springboot
 * @ClassName AbstractBeanFactory
 * @description:
 * @author: xiongfeng
 * @create: 2022-09-26 13:43
 **/
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegister implements BeanFactory {

	@Override
	public Object getBean(String name) {
		Object bean = getSingleton(name);
		if(bean !=null){
			return bean;
		}
		BeanDefinition beanDefinition = getBeanDefinition(name);
		return createBean(name, beanDefinition);
	}

	protected abstract BeanDefinition getBeanDefinition(String beanName);

	protected abstract Object createBean(String beanName, BeanDefinition beanDefinition);
}
