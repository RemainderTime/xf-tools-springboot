package com.xf.smallspring.bean02test;

import org.springframework.stereotype.Service;

/**
 * @program: xf-tools-springboot
 * @ClassName UserService
 * @description:
 * @author: xiongfeng
 * @create: 2022-09-27 14:22
 **/
@Service
public class UserService {

	public void queryInfo(){
		System.out.println("获取用户数据成功！");
	}
}
