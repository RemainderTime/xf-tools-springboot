package com.xf.smallspring.bean02;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: xf-tools-springboot
 * @ClassName BeanFactory
 * @description: bean工厂类
 * @author: xiongfeng
 * @create: 2022-09-22 10:16
 **/
public interface BeanFactory {


	Object getBean(String name);

}
